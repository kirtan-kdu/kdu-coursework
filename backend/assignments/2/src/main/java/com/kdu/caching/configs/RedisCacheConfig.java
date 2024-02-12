package com.kdu.caching.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;
import java.time.Duration;

@EnableCaching
@SpringBootConfiguration
public class RedisCacheConfig extends CachingConfigurerSupport {


    /**
     * A custom Redis configuration for Redis cache for both geocoding and reversecoding caches
     */

    public final LettuceConnectionFactory lettuceConnectionFactory;

    @Autowired
    public RedisCacheConfig(LettuceConnectionFactory lettuceConnectionFactory){
        this.lettuceConnectionFactory = lettuceConnectionFactory;
    }

    @PostConstruct
    public void init() {
        try (RedisConnection connection = lettuceConnectionFactory.getConnection()) {
            connection.serverCommands().setConfig("maxmemory", "10mb");
            connection.serverCommands().setConfig("maxmemory-policy", "allkeys-lru");
        }
    }
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
    }

    @Bean
    @Override
    public RedisCacheManager cacheManager() {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10)); // Set cache expiration time

        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(lettuceConnectionFactory)
                .cacheDefaults(cacheConfiguration);

        // Creating geocoding cache
        builder.withCacheConfiguration("geocoding", cacheConfiguration.entryTtl(Duration.ofMinutes(5)));

        // Creating reverse-geocoding cache
        builder.withCacheConfiguration("reverse-geocoding", cacheConfiguration.entryTtl(Duration.ofMinutes(10)));

        return builder.build();
    }

}
