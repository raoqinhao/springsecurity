package com.hh.springsecurity.service;

import com.hh.springsecurity.pojo.UserBean;

public interface UserService {

    UserBean findUserById(String id);
}
