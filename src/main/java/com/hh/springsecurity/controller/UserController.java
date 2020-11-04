package com.hh.springsecurity.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hh.springsecurity.pojo.UserBean;
import com.hh.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String toIndex(HttpServletRequest request) {
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (auth != null && auth != "") {
            JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(auth));
            String username = jsonObject.getString("username");
            UserBean userBean = userService.findUserByUserName(username);
            request.getSession().setAttribute("UserBean", userBean);
        }
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
