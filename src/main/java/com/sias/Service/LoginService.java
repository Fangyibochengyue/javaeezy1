package com.sias.Service;

import com.sias.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    Boolean login(User user);
}
