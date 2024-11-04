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
package com.nextdoor.api.advertising;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.PaginationParameters;
import com.nextdoor.models.UserStatus;
import com.nextdoor.models.advertising.ad.Ad;
import com.nextdoor.models.advertising.ad.AdList;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPIAd extends NextDoorAPIRequestNode {
    public NextDoorAPIAd() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIAd(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateAd createAd() {
        return new NextDoorAPICreateAd(this.nextDoorAPIAuth);
    }

    public NextDoorAPIUpdateAd updateAd() {
        return new NextDoorAPIUpdateAd(this.nextDoorAPIAuth);
    }

    public NextDoorAPIUpdateAdStatus updateAdStatus() {
        return new NextDoorAPIUpdateAdStatus(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPICreateAd extends NextDoorAPIRequest<Ad> implements NextDoorAPIExecute<Ad> {
        public NextDoorAPICreateAd(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Ad.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateAd setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateAd setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPICreateAd setAdGroupId(String adGroupId) {
            this.setParamInternal("ad_group_id", adGroupId);

            return this;
        }

        public NextDoorAPICreateAd setCreativeId(String creativeId) {
            this.setParamInternal("creative_id", creativeId);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "ad/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("name"), "name");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("adgroup_id"), "adgroup_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("creative_id"), "creative_id");
        }

        @Override
        public Ad execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdCreateException("Can't create advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdCreateException extends APIRequestException {
            public AdCreateException() {
            }

            public AdCreateException(String s) {
                super(s);
            }

            public AdCreateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdCreateException(Throwable throwable) {
                super(throwable);
            }

            public AdCreateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIUpdateAd extends NextDoorAPIRequest<Ad> implements NextDoorAPIExecute<Ad> {
        public NextDoorAPIUpdateAd(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Ad.class, nextDoorAPIAuth);
        }

        public NextDoorAPIUpdateAd setId(String id) {
            this.setParamInternal("id", id);

            return this;
        }

        public NextDoorAPIUpdateAd setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIUpdateAd setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIUpdateAd setCreativeId(String creativeId) {
            this.setParamInternal("creative_id", creativeId);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "ad/update";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Ad execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdUpdateException("Can't update Ad, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdUpdateException extends APIRequestException {
            public AdUpdateException() {
            }

            public AdUpdateException(String s) {
                super(s);
            }

            public AdUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdUpdateException(Throwable throwable) {
                super(throwable);
            }

            public AdUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIUpdateAdStatus extends NextDoorAPIRequest<Ad> implements NextDoorAPIExecute<Ad> {
        public NextDoorAPIUpdateAdStatus(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Ad.class, nextDoorAPIAuth);
        }

        public NextDoorAPIUpdateAdStatus setId(String id) {
            this.setParamInternal("id", id);

            return this;
        }

        public NextDoorAPIUpdateAdStatus setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIUpdateAdStatus setUserStatus(UserStatus userStatus) {
            this.setParamInternal("user_status", userStatus);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "ad/status/update";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Ad execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdStatusUpdateException("Can't update Ad status, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdStatusUpdateException extends APIRequestException {
            public AdStatusUpdateException() {
            }

            public AdStatusUpdateException(String s) {
                super(s);
            }

            public AdStatusUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdStatusUpdateException(Throwable throwable) {
                super(throwable);
            }

            public AdStatusUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAdList extends NextDoorAPIRequest<AdList> implements NextDoorAPIExecute<AdList> {
        public NextDoorAPIAdList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdList.class, nextDoorAPIAuth);
        }

        public NextDoorAPIAdList setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIAdList setAdGroupId(String adGroupId) {
            this.setParamInternal("adgroup_id", adGroupId);

            return this;
        }

        public NextDoorAPIAdList setPaginationParameters(PaginationParameters paginationParameters) {
            this.setParamInternal("pagination_parameters", paginationParameters);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "ad/list";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("adgroup_id"), "adgroup_id");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("pagination_parameters"), "pagination_parameters");
        }

        @Override
        public AdList execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdListNotFoundException("Can't find Ad list, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdListNotFoundException extends APIRequestException {
            public AdListNotFoundException() {
            }

            public AdListNotFoundException(String s) {
                super(s);
            }

            public AdListNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdListNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdListNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
