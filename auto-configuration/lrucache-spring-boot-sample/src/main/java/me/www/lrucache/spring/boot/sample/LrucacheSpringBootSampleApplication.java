package me.www.lrucache.spring.boot.sample;

import me.www.lrucache.LRUCache;
import me.www.lrucache.spring.boot.autoconfigure.LRUCacheAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * @author www
 */
@SpringBootApplication
//@EnableAutoConfiguration(exclude = LRUCacheAutoConfiguration.class)
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
