package com.yyb.service.impl;

import com.yyb.bean.User;
import com.yyb.dao.UserMapper;
import com.yyb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper dao;


    @Transactional
    @Override
    public boolean emailExist(String email) throws Exception {

        if(dao.findUserByEmail(email)!=null){
            return true;
        }else
            return false;
    }

    @Transactional
    @Override
    public boolean register(User user) throws Exception {

        int i = dao.insertUser(user);

        if (i==1){
            return true;
        }else
            return false;
    }

    @Transactional
    @Override
    public User login(String email, String password) throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("email",email);
        map.put("password",password);

        //测试事务是否开启
      //  int i = 1 / 0 ;

        User userByEmailAndPwd = dao.findUserByEmailAndPwd(map);

        return userByEmailAndPwd;

    }
}
