package me.www.lrucache.spring.boot.autoconfigure;

import org.springframework.util.Assert;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * Mappings between {@link LRUCacheType} and {@code @Configuration}.
 *
 * @author www
 */
final class LRUCacheConfigurations {

    private static final Map<LRUCacheType, Class<?>> MAPPINGS;

    static {
        Map<LRUCacheType, Class<?>> mappings = new EnumMap<>(LRUCacheType.class);
        mappings.put(LRUCacheType.NON_CONCURRENT, NonConcurrentLRUCacheConfiguration.class);
        mappings.put(LRUCacheType.CONCURRENT, ConcurrentLRUCacheConfiguration.class);
        MAPPINGS = Collections.unmodifiableMap(mappings);
    }

    private LRUCacheConfigurations() {
    }

    public static String getConfigurationClass(LRUCacheType lruCacheType) {
        Class<?> configurationClass = MAPPINGS.get(lruCacheType);
        Assert.state(configurationClass != null, () -> "Unknown cache type " + lruCacheType);
        return configurationClass.getName();
    }

    public static LRUCacheType getType(String configurationClassName) {
        for (Map.Entry<LRUCacheType, Class<?>> entry : MAPPINGS.entrySet()) {
            if (entry.getValue().getName().equals(configurationClassName)) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException(
                "Unknown configuration class " + configurationClassName);
    }

}