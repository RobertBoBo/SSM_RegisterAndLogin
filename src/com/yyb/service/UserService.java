package com.yyb.service;

import com.yyb.bean.User;

public interface UserService {

    boolean emailExist(String email) throws Exception;

    boolean register(User user) throws Exception;

    User login(String email, String password) throws Exception;

}
