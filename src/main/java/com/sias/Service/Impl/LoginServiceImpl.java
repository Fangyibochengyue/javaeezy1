package com.sias.Service.Impl;
import com.sias.Service.LoginService;
import com.sias.dao.LoginMapper;
import com.sias.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    public Boolean login(User user) {
        int flag=loginMapper.login(user);
        if (flag==1){
            return true;
        }else {
            return false;
        }
    }
}
