package com.madadipouya.telegram.corona.general.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * This file is part of COVID-19-Telegram-bot.
 *
 * COVID-19-Telegram-bot is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation.
 *
 * COVID-19-Telegram-bot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.  <http://www.gnu.org/licenses/>
 *
 * Author(s):
 *
 * © 2020 Kasra Madadipouya <kasra@madadipouya.com>
 */

@Configuration
@EnableCaching
public class CacheManagerConfig {

    private final Logger logger = LoggerFactory.getLogger(CacheManagerConfig.class);

    public static final String OPEN_STREET_CACHE = "openStreetCache";

    public static final String CORONA_ALL_STATISTICS_CACHE = "coronaAllStatisticsCache";

    public static final String CORONA_ALL_STATISTICS_FLAT_CACHE = "coronaAllStatisticsCacheFlat";

    public static final String CORONA_COUNTRY_STATISTICS_CACHE = "coronaCountryStatisticsCache";

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        CaffeineCache openStreetCache = new CaffeineCache(OPEN_STREET_CACHE, Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .build());

        CaffeineCache coronaAllStatisticsCache = new CaffeineCache(CORONA_ALL_STATISTICS_CACHE, Caffeine.newBuilder()
                .maximumSize(10)
                .build());

        CaffeineCache coronaAllStatisticsFlatCache = new CaffeineCache(CORONA_ALL_STATISTICS_FLAT_CACHE, Caffeine.newBuilder()
                .maximumSize(10)
                .build());

        CaffeineCache coronaCountryStatisticsCache = new CaffeineCache(CORONA_COUNTRY_STATISTICS_CACHE, Caffeine.newBuilder()
                .maximumSize(1000)
                .build());

        cacheManager.setCaches(List.of(openStreetCache, coronaAllStatisticsCache, coronaAllStatisticsFlatCache, coronaCountryStatisticsCache));
        return cacheManager;
    }

    // run every 30 minutes
    @Scheduled(cron = "0 0/30 * * * ?")
    @CacheEvict(value = {CORONA_ALL_STATISTICS_CACHE, CORONA_ALL_STATISTICS_FLAT_CACHE, CORONA_COUNTRY_STATISTICS_CACHE}, allEntries = true)
    public void evictCoronaCaches() {
        logger.info("Evicted all Corona caches!");
    }
}
