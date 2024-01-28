package com.kdu.caching.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class CacheRepo {


    /**
     * Custom repository for CRUD operations on Cache, can be used as a template for any caches
     */


    private final CacheManager cacheManager;

    @Autowired
    public CacheRepo(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    public Boolean isStored(String cacheName, Object key){
        Cache cache = cacheManager.getCache(cacheName);
        return Objects.requireNonNull(cache).get(key) != null;
    }

    public String get(String cacheName, String key){
        Cache cache = cacheManager.getCache(cacheName);
        Cache.ValueWrapper valueWrapper = Objects.requireNonNull(cache).get(key);
        return Objects.requireNonNull(Objects.requireNonNull(valueWrapper).get()).toString();
    }

    public void put(String cacheName, String key, String value){
        Objects.requireNonNull(Objects.requireNonNull(cacheManager).getCache(cacheName)).put(key,value);
    }
}
