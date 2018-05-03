package me.www.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: www
 * @date: 2018/4/29 16:55
 * @description: TODO
 */
@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }

}
