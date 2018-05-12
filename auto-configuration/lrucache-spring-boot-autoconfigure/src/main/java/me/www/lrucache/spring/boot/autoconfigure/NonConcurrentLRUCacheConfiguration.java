package me.www.lrucache.spring.boot.autoconfigure;

import me.www.lrucache.LRUCache;
import me.www.nclrucache.NonConcurrentLRUCache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * NonConcurrentLRUCache configuration.
 *
 * @author www
 */
@Configuration
@ConditionalOnClass({LRUCache.class, NonConcurrentLRUCache.class})
@ConditionalOnMissingBean(LRUCache.class)
@Conditional({LRUCacheCondition.class})
class NonConcurrentLRUCacheConfiguration {

    private final LRUCacheProperties lruCacheProperties;

    NonConcurrentLRUCacheConfiguration(LRUCacheProperties lruCacheProperties) {
        this.lruCacheProperties = lruCacheProperties;
    }


    @Bean
    public NonConcurrentLRUCache lruCache() {
        return new NonConcurrentLRUCache(lruCacheProperties.getCacheSize());
    }

}
