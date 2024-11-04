/*
 * Copyright (c) 2024 Nika Beridze
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.nextdoor.models.advertising.ad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ad extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("adgroup_id")
    private String adGroupId;

    @JsonProperty("creative_id")
    private String creativeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("user_status")
    private String userStatus;

    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonProperty("updated_at")
    private Instant updatedAt;

    public Ad() {

    }

    public Ad(String id, String advertiserId, String adGroupId, String creativeId, String name, String status, String userStatus, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.adGroupId = adGroupId;
        this.creativeId = creativeId;
        this.name = name;
        this.status = status;
        this.userStatus = userStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdGroupId() {
        return adGroupId;
    }

    public void setAdGroupId(String adGroupId) {
        this.adGroupId = adGroupId;
    }

    public String getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(String creativeId) {
        this.creativeId = creativeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", adGroupId='" + adGroupId + '\'' +
                ", creativeId='" + creativeId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public static Ad findById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIFindAdById(nextDoorAPIAuth, id).execute();
    }

    public static NextDoorAPIFindAdStatsById findAdStatsById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIFindAdStatsById(nextDoorAPIAuth, id);
    }

    static class NextDoorAPIFindAdById extends NextDoorAPIRequest<Ad> implements NextDoorAPIExecute<Ad> {
        private final String id;

        public NextDoorAPIFindAdById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(Ad.class, nextDoorAPIAuth);


            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "ad/get/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Ad execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AdNotFoundException("Cannot find Ad with id: " + this.id + " because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdNotFoundException extends APIRequestException {
            public AdNotFoundException() {
            }

            public AdNotFoundException(String s) {
                super(s);
            }

            public AdNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIFindAdStatsById extends NextDoorAPIRequest<AdStats> implements NextDoorAPIExecute<AdStats> {
        private final String id;

        public NextDoorAPIFindAdStatsById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(AdStats.class, nextDoorAPIAuth);


            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        public NextDoorAPIFindAdStatsById setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIFindAdStatsById setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIFindAdStatsById setStartTime(Date startTime) {
            return setStartTime(NextDoorUtil.formatDate(startTime));
        }

        public NextDoorAPIFindAdStatsById setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        public NextDoorAPIFindAdStatsById setEndTime(Date endTime) {
            return setEndTime(NextDoorUtil.formatDate(endTime));
        }

        @Override
        protected String getPath() {
            return "ad/get/" + this.id + "/stats";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdStats execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdStatsNotFoundException("Can't find Ad stats by ID " + this.id + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdStatsNotFoundException extends APIRequestException {
            public AdStatsNotFoundException() {
            }

            public AdStatsNotFoundException(String s) {
                super(s);
            }

            public AdStatsNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdStatsNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdStatsNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
