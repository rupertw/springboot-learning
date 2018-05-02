package me.www.helloworld.controller;

import me.www.helloworld.util.ApplicationContextHolder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * @author: www
 * @date: 2018/4/29 16:55
 * @description: 关于spring应用上下文
 */
@RestController
public class ApplicationContextTestController implements ServletContextAware, ApplicationContextAware {

    private ServletContext servletContext;

    private ApplicationContext applicationContext;

    @GetMapping("/applicationContextTest")
    public String applicationContextTest() {
        WebApplicationContext root = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        // true
        System.out.println(ApplicationContextHolder.applicationContext == root);

        // true
        System.out.println(this.applicationContext == root);

        Map<String, ServletContext> map = root.getBeansOfType(ServletContext.class);

        return "Hello,World!";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
