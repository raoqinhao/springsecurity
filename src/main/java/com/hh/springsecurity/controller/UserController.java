package com.hh.springsecurity.controller;


import com.hh.springsecurity.pojo.UserBean;
import com.hh.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

//    @RequestMapping("/toError")
//    public String toError() {
//        return "error";
//    }

    @RequestMapping("/findUserById/{id}")
    @ResponseBody
    public UserBean findUserById(@PathVariable String id) {
//        UserBean userBean = userService.findUserById(id);
        return null;
    }




}
