package me.www.lrucache.spring.boot.autoconfigure;

import me.www.lrucache.LRUCache;
import me.www.nclrucache.NonConcurrentLRUCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Conditional({LRUCacheCondition.class})
class NonConcurrentLRUCacheConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(NonConcurrentLRUCacheConfiguration.class);

    private final LRUCacheProperties lruCacheProperties;

    NonConcurrentLRUCacheConfiguration(LRUCacheProperties lruCacheProperties) {
        this.lruCacheProperties = lruCacheProperties;
    }

    @Bean
    @ConditionalOnMissingBean(LRUCache.class)
    public NonConcurrentLRUCache lruCache() {
        logger.info("LRUCache: Bean of Type NonConcurrentLRUCache is initialized");
        return new NonConcurrentLRUCache(lruCacheProperties.getCacheSize());
    }

}
