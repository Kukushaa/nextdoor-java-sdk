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
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.*;
import com.nextdoor.models.advertising.advertiser.*;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPIAdvertiser extends NextDoorAPIRequestNode {
    public NextDoorAPIAdvertiser() {

    }

    public NextDoorAPIAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateAdvertiser createAdvertiser() {
        return new NextDoorAPICreateAdvertiser(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIUpdateAdvertiser updateAdvertiser() {
        return new NextDoorAPIUpdateAdvertiser(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIAdvertiserCategoriesList findAdvertiserCategoriesListById(String id) {
        return new NextDoorAPIAdvertiserCategoriesList(this.getNextDoorAPIAuth(), id);
    }

    public NextDoorAPIAdvertiserCampaignList findAdvertiserCampaignListById(String id) {
        return new NextDoorAPIAdvertiserCampaignList(this.getNextDoorAPIAuth(), id);
    }

    public NextDoorAPIAdvertiserCreativeList findAdvertiserCreativeListById(String id) {
        return new NextDoorAPIAdvertiserCreativeList(this.getNextDoorAPIAuth(), id);
    }

    public NextDoorAPIAdvertiserReportingScheduledList findAdvertiserReportingScheduledListById(String id) {
        return new NextDoorAPIAdvertiserReportingScheduledList(this.getNextDoorAPIAuth(), id);
    }

    public NextDoorAPIAdvertiserReportingList findAdvertiserReportingListById(String id) {
        return new NextDoorAPIAdvertiserReportingList(this.getNextDoorAPIAuth(), id);
    }

    public static class NextDoorAPICreateAdvertiser extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        public NextDoorAPICreateAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Advertiser.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateAdvertiser setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateAdvertiser setWebsiteUrl(String websiteUrl) {
            this.setParamInternal("website_url", websiteUrl);

            return this;
        }

        public NextDoorAPICreateAdvertiser setCategoryId(String categoryId) {
            this.setParamInternal("category_id", categoryId);

            return this;
        }

        @Override
        public Advertiser execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserCreationException("Can't create advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "advertiser/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("name"), "name");
        }

        public static class AdvertiserCreationException extends APIRequestException {
            public AdvertiserCreationException() {
            }

            public AdvertiserCreationException(String s) {
                super(s);
            }

            public AdvertiserCreationException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserCreationException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserCreationException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIUpdateAdvertiser extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        public NextDoorAPIUpdateAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Advertiser.class, nextDoorAPIAuth);
        }

        public NextDoorAPIUpdateAdvertiser setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setWebsiteUrl(String websiteUrl) {
            this.setParamInternal("website_url", websiteUrl);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setUserSetBillingLimit(String userSetBillingLimit) {
            this.setParamInternal("user_set_billing_limit", userSetBillingLimit);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setCategoryId(String categoryId) {
            this.setParamInternal("category_id", categoryId);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setAddress(Advertiser.Address address) {
            this.setParamInternal("address", address);

            return this;
        }

        public NextDoorAPIUpdateAdvertiser setBillToPaymentProfileId(String billToPaymentProfileId) {
            this.setParamInternal("bill_to_payment_profile_id", billToPaymentProfileId);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/update";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
        }

        @Override
        public Advertiser execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserUpdateException("Can't update advertiser campaign, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserUpdateException extends APIRequestException {
            public AdvertiserUpdateException() {
            }

            public AdvertiserUpdateException(String s) {
                super(s);
            }

            public AdvertiserUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserUpdateException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAdvertiserCategoriesList extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        private final String advertiserId;

        public NextDoorAPIAdvertiserCategoriesList(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId) {
            super(Advertiser.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
            this.setParamInternal("advertiser_id", advertiserId);
            this.advertiserId = advertiserId;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/categories/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Advertiser execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserCategoriesListFoundException("Can't find Advertiser categories list by ID " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserCategoriesListFoundException extends APIRequestException {
            public AdvertiserCategoriesListFoundException() {
            }

            public AdvertiserCategoriesListFoundException(String s) {
                super(s);
            }

            public AdvertiserCategoriesListFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserCategoriesListFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserCategoriesListFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAdvertiserCampaignList extends NextDoorAPIRequest<AdvertiserCampaigns> implements NextDoorAPIExecute<AdvertiserCampaigns> {
        private final String advertiserId;

        public NextDoorAPIAdvertiserCampaignList(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId) {
            super(AdvertiserCampaigns.class, nextDoorAPIAuth);

            
            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
            this.setParamInternal("advertiser_id", advertiserId);
            this.advertiserId = advertiserId;
        }

        public NextDoorAPIAdvertiserCampaignList setPaginationParameters(PaginationParameters paginationParameters) {
            this.setParamInternal("pagination_parameters", paginationParameters);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/campaign/list";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("pagination_parameters"), "pagination_parameters");
        }

        @Override
        public AdvertiserCampaigns execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserCampaignListFoundException("Can't find Advertiser campaign list by ID " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserCampaignListFoundException extends APIRequestException {
            public AdvertiserCampaignListFoundException() {
            }

            public AdvertiserCampaignListFoundException(String s) {
                super(s);
            }

            public AdvertiserCampaignListFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserCampaignListFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserCampaignListFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAdvertiserCreativeList extends NextDoorAPIRequest<AdvertiserCreatives> implements NextDoorAPIExecute<AdvertiserCreatives> {
        private final String advertiserId;

        public NextDoorAPIAdvertiserCreativeList(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId) {
            super(AdvertiserCreatives.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
            this.setParamInternal("advertiser_id", advertiserId);
            this.advertiserId = advertiserId;
        }

        public NextDoorAPIAdvertiserCreativeList setPaginationParameters(PaginationParameters paginationParameters) {
            this.setParamInternal("pagination_parameters", paginationParameters);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/creative/list";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("pagination_parameters"), "pagination_parameters");
        }

        @Override
        public AdvertiserCreatives execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserCreativeNotFound("Can't find Advertiser creative list by ID " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserCreativeNotFound extends APIRequestException {
            public AdvertiserCreativeNotFound() {
            }

            public AdvertiserCreativeNotFound(String s) {
                super(s);
            }

            public AdvertiserCreativeNotFound(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserCreativeNotFound(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserCreativeNotFound(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAdvertiserReportingScheduledList extends NextDoorAPIRequest<AdvertiserReportingScheduledList> implements NextDoorAPIExecute<AdvertiserReportingScheduledList> {
        private final String advertiserId;

        public NextDoorAPIAdvertiserReportingScheduledList(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId) {
            super(AdvertiserReportingScheduledList.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
            this.setParamInternal("advertiser_id", advertiserId);
            this.advertiserId = advertiserId;
        }

        public NextDoorAPIAdvertiserReportingScheduledList setPaginationParameters(PaginationParameters paginationParameters) {
            this.setParamInternal("pagination_parameters", paginationParameters);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "reporting/scheduled/list";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("pagination_parameters"), "pagination_parameters");
        }

        @Override
        public AdvertiserReportingScheduledList execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserReportingScheduledListNotFound("Can't find Advertiser reporting scheduled list by ID " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserReportingScheduledListNotFound extends APIRequestException {
            public AdvertiserReportingScheduledListNotFound() {
            }

            public AdvertiserReportingScheduledListNotFound(String s) {
                super(s);
            }

            public AdvertiserReportingScheduledListNotFound(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserReportingScheduledListNotFound(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserReportingScheduledListNotFound(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAdvertiserReportingList extends NextDoorAPIRequest<AdvertiserReportingList> implements NextDoorAPIExecute<AdvertiserReportingList> {
        private final String advertiserId;

        public NextDoorAPIAdvertiserReportingList(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId) {
            super(AdvertiserReportingList.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
            this.setParamInternal("advertiser_id", advertiserId);
            this.advertiserId = advertiserId;
        }

        public NextDoorAPIAdvertiserReportingList setPaginationParameters(PaginationParameters paginationParameters) {
            this.setParamInternal("pagination_parameters", paginationParameters);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/reportinglist";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("pagination_parameters"), "pagination_parameters");
        }

        @Override
        public AdvertiserReportingList execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserReportingListNotFound("Can't find Advertiser reporting list by ID " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserReportingListNotFound extends APIRequestException {
            public AdvertiserReportingListNotFound() {
            }

            public AdvertiserReportingListNotFound(String s) {
                super(s);
            }

            public AdvertiserReportingListNotFound(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserReportingListNotFound(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserReportingListNotFound(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
