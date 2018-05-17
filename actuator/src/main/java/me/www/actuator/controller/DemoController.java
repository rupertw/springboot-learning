package me.www.actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: www
 * @date: 2018/5/17 22:48
 * @description: TODO
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "Demo!";
    }

}
