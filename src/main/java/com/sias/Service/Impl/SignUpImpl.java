package com.sias.Service.Impl;


import com.sias.Service.SignUpService;
import com.sias.dao.SignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpImpl implements SignUpService {
    @Autowired
    private SignUpMapper signUpMapper;
    @Override
    public boolean seletByname(String username) {
        int ss=signUpMapper.slectByName(username);
        if (ss==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void register(String username, String password,String tel,String email) {
        signUpMapper.InsertUU(username,password,tel,email);
    }
}
