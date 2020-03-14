package com.madadipouya.telegram.corona.virus.integration.openstreetmap.remote.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenStreetMapLocationResponse {

    public OpenStreetMapLocationResponse() {
        this.address = null;
        this.boundingBox = null;
        this.displayName = "";
        this.latitude = "";
        this.longitude = "";
        this.license = "";
        this.osmId = "";
        this.osmType = "";
    }

    @JsonProperty("place_id")
    private String placeId;

    @JsonProperty("license")
    private String license;

    @JsonProperty("osm_type")
    private String osmType;

    @JsonProperty("osm_id")
    private String osmId;

    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("lon")
    private String longitude;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("boundingbox")
    private List<String> boundingBox;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getOsmType() {
        return osmType;
    }

    public void setOsmType(String osmType) {
        this.osmType = osmType;
    }

    public String getOsmId() {
        return osmId;
    }

    public void setOsmId(String osmId) {
        this.osmId = osmId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(List<String> boundingBox) {
        this.boundingBox = boundingBox;
    }

    public static class Address {

        public Address() {
            this.country = "";
            this.countryCode = "";
            this.road = "";
            this.state = "";
        }

        private String road;
        private String state;
        private String country;
        @JsonProperty("country_code")
        private String countryCode;

        public String getRoad() {
            return road;
        }

        public void setRoad(String road) {
            this.road = road;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }
    }
}
