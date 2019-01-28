package com.gd.azure.poc.service.config;

import com.gd.azure.poc.domain.Store;
import java.io.File;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    private PersistentCacheManager cacheManager;

    public CacheConfig() {
        cacheManager =
            CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence("/tmp"
                    + File.separator
                    + "cache"))
                .withCache("storeCache", CacheConfigurationBuilder
                    .newCacheConfigurationBuilder(String.class, Store.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                            .heap(10000, EntryUnit.ENTRIES)
                            .disk(10000, MemoryUnit.MB, true))
                )
                .build(true);
    }
}
