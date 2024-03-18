package com.sias.Controller;

import com.sias.Service.LoginService;
import com.sias.common.R;
import com.sias.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class LoginController {
   @Autowired
   private LoginService loginService;

   /**
    * 登录
    * @param user
    * @return
    */
   @PostMapping("/login")
   public R<String> login(HttpServletRequest request, @RequestBody User user) {
      System.out.println(user);
      Boolean flog = loginService.login(user);
      System.out.println(flog);
      if (flog) {
         request.getSession().setAttribute("User",user.getId());
         return R.success("登录成功");
      }else {
         return R.error("登录失败");
      }
   }
}
