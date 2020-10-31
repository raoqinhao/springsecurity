package com.hh.springsecurity.service;

import com.hh.springsecurity.pojo.UserBean;

import java.util.List;

public interface UserService {

    UserBean findUserById(String id);

    String saveUserByRegister(String json);

    List<UserBean> findAllUser();

    void findUserByMulThread();

}
