package com.hh.springsecurity.service;

import com.hh.springsecurity.mapper.UserMapper;
import com.hh.springsecurity.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean findUserById(String id) {
//        UserBean userBean = userMapper.findUserById(Integer.valueOf(id));
//        return userBean;
        return null;
    }

}
