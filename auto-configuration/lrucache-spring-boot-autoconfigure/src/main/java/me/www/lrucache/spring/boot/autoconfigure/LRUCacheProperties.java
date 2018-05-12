package me.www.lrucache.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for lrucache.
 *
 * @author: www
 * @date: 2018/5/12 16:39
 * @description: TODO
 */
@ConfigurationProperties(prefix = LRUCacheProperties.LRUCACHE_PREFIX)
public class LRUCacheProperties {

    public static final String LRUCACHE_PREFIX = "lrucache";

    /**
     * LRUCache type. By default, auto-detected according to the environment.
     */
    private LRUCacheType type;

    /**
     * cacheSize
     */
    private Integer cacheSize;

    public LRUCacheType getType() {
        return type;
    }

    public void setType(LRUCacheType type) {
        this.type = type;
    }

    public Integer getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Integer cacheSize) {
        this.cacheSize = cacheSize;
    }
}
