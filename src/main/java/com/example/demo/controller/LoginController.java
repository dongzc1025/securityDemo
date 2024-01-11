package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Jiangnan Cui
 * @Date 2022/7/23 17:47
 * @Version 1.0
 */
@Controller
public class LoginController {
    @RequestMapping("/login.html") //注意此处是login.html而不是login
    public String login() {
        return "login";//封装为login.html
    }
}
