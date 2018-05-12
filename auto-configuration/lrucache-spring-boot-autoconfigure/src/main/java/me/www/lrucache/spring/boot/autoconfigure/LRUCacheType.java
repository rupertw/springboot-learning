package me.www.lrucache.spring.boot.autoconfigure;

/**
 * Supported cache types (defined in order of precedence).
 *
 * @author: www
 * @date: 2018/5/12 19:29
 * @description: TODO
 */
public enum LRUCacheType {

    /**
     * NonConcurrentLRUCache backed caching.
     */
    NON_CONCURRENT,

    /**
     * ConcurrentLRUCache backed caching.
     */
    CONCURRENT

}
