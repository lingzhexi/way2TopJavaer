package com.zxling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @ClassName: HelloController
 * @Author: lingzx
 * @Date 2019/10/16 14:48:17
 * @Version 1.0
 **/
@Controller
@RequestMapping("/say")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
