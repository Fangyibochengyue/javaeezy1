package com.sias.filter;

import com.alibaba.fastjson.JSON;

import com.sias.filter.BaseContext;
import com.sias.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检测用户是否已经完成登录
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER=new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        //1.获取本次请求的uri
        String requestURI = request.getRequestURI();
        log.info("拦截到请求{}",requestURI);
        //定义不需要处理的请求路径
        String[] urls=new String[]{
                "/login",
                "/register",
                "/register.html"
        };
        //2.判断本次请求是否需要处理
        boolean check = check(urls, requestURI);
        //3.如果不需要处理，则直接放行
        if (check){
            log.info("本次请求不需要处理",requestURI);
            filterChain.doFilter(request,response);

            return;
        }
        //4-1.判断pc端登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("User")!=null){
            log.info("用户已登录用户id：{}",request.getSession().getAttribute("User"));
            int empID = (int) request.getSession().getAttribute("User");
            BaseContext.setCurrentId(empID);
            filterChain.doFilter(request,response);
            return;
        }
        //4-2.判断移动端用户登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("User")!=null){
            log.info("用户已登录用户id：{}",request.getSession().getAttribute("User"));
            int userID = (int)request.getSession().getAttribute("User");

            BaseContext.setCurrentId(userID);

            filterChain.doFilter(request,response);
            return;
        }
        log.info("用户未登录");
        //5.如果未登录则返回未登录的结果
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI){
        for(String url:urls){
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) return true;
        }
        return false;
    }
}
