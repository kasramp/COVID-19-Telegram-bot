package com.madadipouya.telegram.corona.virus.integration.openstreetmap;

import com.madadipouya.telegram.corona.virus.integration.openstreetmap.remote.response.OpenStreetMapLocationResponse;

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

/**
 * This service is responsible to get physical address of a geographical location
 */
public interface OpenStreetMapIntegration {

    /**
     * Gets country code of a geographical location
     *
     * @param latitude  Latitude of location to get the address for
     * @param longitude Longitude of location to get the address for
     * @return Physical address of the location contains the full address
     */
    String getCountryCodeOfGeoLocation(double latitude, double longitude);

    /**
     * Gets physical address of a geographical location
     *
     * @param latitude  Latitude of location to get the address for
     * @param longitude Longitude of location to get the address for
     * @return {@link OpenStreetMapLocationResponse} The physical address of the location
     */
    OpenStreetMapLocationResponse getReverseGeocoding(double latitude, double longitude);
}
