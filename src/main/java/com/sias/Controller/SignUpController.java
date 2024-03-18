package com.sias.Controller;

import com.sias.Service.SignUpService;
import com.sias.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public R<String> signUp(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("phoneNumber") String tel,@RequestParam("email") String email){
        boolean flog=signUpService.seletByname(username);
        if (flog){
            log.info("用户已注册");
            return R.error("用户已注册");
        }else {
            signUpService.register(username,password,tel,email);
            log.info("用户注册成功");
            return R.success("注册成功");
        }
    }
}
