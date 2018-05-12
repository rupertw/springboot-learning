package me.www.lrucache.spring.boot.autoconfigure;

import me.www.lrucache.LRUCache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: www
 * @date: 2018/5/12 16:41
 * @description: TODO
 */
@Configuration
@ConditionalOnClass(LRUCache.class)
@ConditionalOnMissingBean(value = LRUCache.class, name = "lruCache")
@EnableConfigurationProperties(LRUCacheProperties.class)
@Import(LRUCacheAutoConfiguration.LRUCacheConfigurationImportSelector.class)
public class LRUCacheAutoConfiguration {

    /**
     * {@link ImportSelector} to add {@link LRUCacheType} configuration classes.
     */
    static class LRUCacheConfigurationImportSelector implements ImportSelector {

        @Override
        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
            LRUCacheType[] types = LRUCacheType.values();
            String[] imports = new String[types.length];
            for (int i = 0; i < types.length; i++) {
                imports[i] = LRUCacheConfigurations.getConfigurationClass(types[i]);
            }
            return imports;
        }

    }

}
