package com.sias.Service;

import org.springframework.stereotype.Service;

@Service
public interface SignUpService {


    boolean seletByname(String username);

    void register(String username, String password,String tel,String email);
}
