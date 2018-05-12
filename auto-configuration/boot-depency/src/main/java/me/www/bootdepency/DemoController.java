package me.www.bootdepency;

import me.www.lrucache.LRUCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: www
 * @date: 2018/5/12 18:29
 * @description: TODO
 */
@RestController
public class DemoController {

    @Autowired(required = false)
    private LRUCache lruCache;

    @GetMapping("demo")
    public String demo() {
        if (lruCache != null) {
            lruCache.put("k1", "v1");
            lruCache.put("k2", "v2");
            lruCache.put("k3", "v3");
            lruCache.put("k4", "v4");
            lruCache.get("k1");
            lruCache.put("k5", "v5");
            System.out.println(lruCache);
        }

        return "demo";
    }

}
