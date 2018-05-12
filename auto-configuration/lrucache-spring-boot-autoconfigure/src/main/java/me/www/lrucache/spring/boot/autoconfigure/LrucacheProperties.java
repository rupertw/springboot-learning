package me.www.lrucache.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for lrucache.
 *
 * @author: www
 * @date: 2018/5/12 16:39
 * @description: TODO
 */
@ConfigurationProperties(prefix = LrucacheProperties.LRUCACHE_PREFIX)
public class LrucacheProperties {

    public static final String LRUCACHE_PREFIX = "lrucache";

    /**
     * Type
     */
    private String type;

    /**
     * cacheSize
     */
    private Integer cacheSize;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Integer cacheSize) {
        this.cacheSize = cacheSize;
    }
}
