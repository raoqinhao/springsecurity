package com.hh.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModuleController {


    @RequestMapping("/page/{pagePath}")
    public String commonPageJump(@PathVariable String pagePath) {
        return pagePath;
    }


}
