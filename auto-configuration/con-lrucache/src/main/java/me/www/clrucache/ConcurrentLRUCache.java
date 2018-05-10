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

    public static final int DEFAULT_CONCURENCY_LEVEL = 32;

    private final ConcurrentLinkedHashMap<K, V> map;

    public ConcurrentLRUCache(int cacheSize) {
        this(cacheSize, DEFAULT_CONCURENCY_LEVEL);
    }

    private ConcurrentLRUCache(int capacity, int concurrency) {
        map = new ConcurrentLinkedHashMap.Builder<K, V>().weigher(Weighers.<V>singleton())
                .initialCapacity(capacity).maximumWeightedCapacity(capacity)
                .concurrencyLevel(concurrency).build();
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return "ConcurrentLRUCache" + map;
    }
}
