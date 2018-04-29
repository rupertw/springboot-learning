package me.www.helloworld;

import me.www.helloworld.util.ApplicationContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {

        // 返回 root ApplicationContext
        ApplicationContext applicationContext = SpringApplication.run(HelloworldApplication.class, args);

        ApplicationContextHolder.applicationContext = applicationContext;

    }
}
