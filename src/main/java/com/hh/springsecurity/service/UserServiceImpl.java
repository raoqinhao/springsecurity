package com.hh.springsecurity.service;

import com.alibaba.fastjson.JSONObject;
import com.hh.springsecurity.mapper.UserMapper;
import com.hh.springsecurity.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public String saveUserByRegister(String json) {
        try {
            UserBean userBean = JSONObject.parseObject(json, UserBean.class);
            if (userBean != null) {
                userBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
            }
            int result = userMapper.saveUserByRegister(userBean);
            if (result != 0) {
                return "注册成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "注册失败";
        }
        return "注册失败";
    }

}
