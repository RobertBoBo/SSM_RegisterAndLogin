package com.yyb.dao;

import com.yyb.bean.User;

import java.io.IOException;
import java.util.Map;

public interface UserMapper {

    int insertUser(User user) throws IOException;

    User findUserByEmailAndPwd(Map map) throws IOException;

    User findUserByEmail(String email) throws IOException;


}