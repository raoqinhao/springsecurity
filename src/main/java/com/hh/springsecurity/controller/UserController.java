package com.hh.springsecurity.controller;


import com.hh.springsecurity.pojo.UserBean;
import com.hh.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/toError")
    public String toError() {
        return "error";
    }

    @RequestMapping("/toLogout")
    public String toLogout() {
        return "login";
    }

    @RequestMapping("/toRegisterPage")
    public String toRegisterPage() {
        return "register";
    }

    @RequestMapping("/findUserById/{id}")
    @ResponseBody
    public UserBean findUserById(@PathVariable String id) {
        UserBean userBean = userService.findUserById(id);
        return userBean;
    }

    @RequestMapping(value = "/toRegister", method = RequestMethod.POST)
    @ResponseBody
    public String toRegister(@RequestBody String json) {
        return userService.saveUserByRegister(json);
    }

    @RequestMapping(value = "findAllUser")
    @ResponseBody
    public List<UserBean> findAllUser() {
        return userService.findAllUser();
    }


    @RequestMapping("/findUserByMulThread")
    @ResponseBody
    public String findUserByMulThread() {
        userService.findUserByMulThread();
        return "ok";
    }


}
