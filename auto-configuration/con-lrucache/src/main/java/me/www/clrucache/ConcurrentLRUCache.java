package me.www.clrucache;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.Weighers;
import me.www.lrucache.LRUCache;

import java.util.Set;

/**
 * @author: www
 * @date: 2018/5/9 23:12
 * @description: TODO
 */
public class ConcurrentLRUCache<K, V> implements LRUCache<K, V> {

    public static final Integer DEFAULT_CACHE_SIZE = 16;

    public static final int DEFAULT_CONCURENCY_LEVEL = 32;

    private ConcurrentLinkedHashMap<K, V> map;

    public ConcurrentLRUCache() {
        initMap(ConcurrentLRUCache.DEFAULT_CACHE_SIZE, DEFAULT_CONCURENCY_LEVEL);
    }

    public ConcurrentLRUCache(Integer cacheSize) {
        if (cacheSize == null || cacheSize <= 0) {
            cacheSize = ConcurrentLRUCache.DEFAULT_CACHE_SIZE;
        }

        initMap(cacheSize, DEFAULT_CONCURENCY_LEVEL);
    }

    private void initMap(Integer capacity, int concurrency) {
        map = new ConcurrentLinkedHashMap.Builder<K, V>().weigher(Weighers.singleton())
                .initialCapacity(capacity).maximumWeightedCapacity(capacity)
                .concurrencyLevel(concurrency).build();
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return super.toString() + map;
    }
}
