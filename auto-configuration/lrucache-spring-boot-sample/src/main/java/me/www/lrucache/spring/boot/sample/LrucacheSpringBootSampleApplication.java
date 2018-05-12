package me.www.lrucache.spring.boot.sample;

import me.www.lrucache.LRUCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootApplication
public class LrucacheSpringBootSampleApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(LrucacheSpringBootSampleApplication.class, args);

        Map<String, LRUCache> beansMap = applicationContext.getBeansOfType(LRUCache.class);
        for (Map.Entry<String, LRUCache> entry : beansMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
