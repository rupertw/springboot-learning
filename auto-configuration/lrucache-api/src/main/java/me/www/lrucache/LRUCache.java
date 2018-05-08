package me.www.lrucache;

import java.util.Set;

/**
 * @author: www
 * @date: 2018/5/8 22:41
 * @description: TODO
 */
public interface LRUCache<K, V> {

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    void clear();

    Set<K> keySet();

}
