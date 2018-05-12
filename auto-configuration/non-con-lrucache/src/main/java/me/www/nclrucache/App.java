package me.www.nclrucache;

import me.www.lrucache.LRUCache;

/**
 * @author: www
 * @date: 2018/5/8 23:29
 * @description: TODO
 */
public class App {

    public static void main(String[] args) {
        LRUCache<String, String> cache = new NonConcurrentLRUCache<String, String>(4);
        cache.put("k1", "v1");
        cache.put("k2", "v2");
        cache.put("k3", "v3");
        cache.put("k4", "v4");
        cache.get("k1");
        cache.put("k5", "v5");
        System.out.println(cache); // me.www.nclrucache.NonConcurrentLRUCache@74a14482{k3=v3, k4=v4, k1=v1, k5=v5}
    }

}
