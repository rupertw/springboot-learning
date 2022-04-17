package me.www.lrucache.spring.boot.autoconfigure;

import me.www.clrucache.ConcurrentLRUCache;
import me.www.lrucache.LRUCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Conditional({LRUCacheCondition.class})
class ConcurrentLRUCacheConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ConcurrentLRUCacheConfiguration.class);

    private final LRUCacheProperties lruCacheProperties;

    public ConcurrentLRUCacheConfiguration(LRUCacheProperties lruCacheProperties) {
        this.lruCacheProperties = lruCacheProperties;
    }

    @Bean
    @ConditionalOnMissingBean(LRUCache.class)
    public ConcurrentLRUCache lruCache() {
        logger.info("LRUCache: Bean of Type ConcurrentLRUCache is initialized");
        return new ConcurrentLRUCache(lruCacheProperties.getCacheSize());
    }

}
