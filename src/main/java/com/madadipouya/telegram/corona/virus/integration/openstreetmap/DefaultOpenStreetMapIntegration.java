package com.madadipouya.telegram.corona.virus.integration.openstreetmap;

import com.madadipouya.telegram.corona.virus.integration.openstreetmap.remote.response.OpenStreetMapLocationResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.madadipouya.telegram.corona.general.config.CacheManagerConfig.OPEN_STREET_CACHE;
import static java.lang.String.format;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

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

@Service
public class DefaultOpenStreetMapIntegration implements OpenStreetMapIntegration {
    private static final String API_URL = "https://nominatim.openstreetmap.org/reverse?format=json&lat=%s&lon=%s&zoom=18&addressdetails=1";

    private final RestTemplate restTemplate;

    public DefaultOpenStreetMapIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable(value = OPEN_STREET_CACHE, key = "{ #latitude, #longitude }")
    public String getCountryCodeOfGeoLocation(double latitude, double longitude) {
        return getReverseGeocoding(latitude, longitude).getAddress().getCountryCode();
    }

    @Override
    public OpenStreetMapLocationResponse getReverseGeocoding(double latitude, double longitude) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(APPLICATION_JSON));
        headers.setContentType(APPLICATION_JSON);
        headers.set("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:58.0) Gecko/20100101 Firefox/58.0");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(format(API_URL, latitude, longitude),
                GET, entity, OpenStreetMapLocationResponse.class).getBody();
    }
}