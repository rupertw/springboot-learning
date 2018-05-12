package me.www.lrucache.spring.boot.autoconfigure;

import me.www.lrucache.LRUCache;
import me.www.nclrucache.NonConcurrentLRUCache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: www
 * @date: 2018/5/12 16:41
 * @description: TODO
 */
@Configuration
@ConditionalOnClass({LRUCache.class})
@EnableConfigurationProperties(LrucacheProperties.class)
public class LrucacheAutoConfiguration {

    private final LrucacheProperties lrucacheProperties;

    public LrucacheAutoConfiguration(LrucacheProperties lrucacheProperties) {
        this.lrucacheProperties = lrucacheProperties;
    }


    @Bean
    @ConditionalOnClass({NonConcurrentLRUCache.class})
    @ConditionalOnMissingBean
    public NonConcurrentLRUCache nonConcurrentLRUCache() {
        return new NonConcurrentLRUCache(lrucacheProperties.getCacheSize());
    }

}
