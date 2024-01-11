package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Jiangnan Cui
 * @Date 2022/7/4 17:51
 * @Version 1.0
 */
@RestController
public class IndexController {
    @RequestMapping("/index")
    public String hello() {
        System.out.println("Index Spring Security");
        return "index";
    }
}

