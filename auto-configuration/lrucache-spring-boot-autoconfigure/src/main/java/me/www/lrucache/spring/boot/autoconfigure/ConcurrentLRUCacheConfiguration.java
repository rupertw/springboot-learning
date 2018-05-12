package me.www.lrucache.spring.boot.autoconfigure;

import me.www.clrucache.ConcurrentLRUCache;
import me.www.lrucache.LRUCache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * ConcurrentLRUCache configuration.
 *
 * @author www
 */
@Configuration
@ConditionalOnClass({LRUCache.class, ConcurrentLRUCache.class})
@ConditionalOnMissingBean(LRUCache.class)
@Conditional({LRUCacheCondition.class})
class ConcurrentLRUCacheConfiguration {

    private final LRUCacheProperties lruCacheProperties;

    public ConcurrentLRUCacheConfiguration(LRUCacheProperties lruCacheProperties) {
        this.lruCacheProperties = lruCacheProperties;
    }


    @Bean
    public ConcurrentLRUCache lruCache() {
        return new ConcurrentLRUCache(lruCacheProperties.getCacheSize());
    }

}
