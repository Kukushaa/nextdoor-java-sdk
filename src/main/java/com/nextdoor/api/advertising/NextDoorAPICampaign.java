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
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.UserStatus;
import com.nextdoor.models.advertising.campaign.Campaign;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

public class NextDoorAPICampaign extends NextDoorAPIRequestNode {
    public NextDoorAPICampaign() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPICampaign(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateCampaign createCampaign() {
        return new NextDoorAPICreateCampaign(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIUpdateCampaign updateCampaign(String campaignId) {
        return new NextDoorAPIUpdateCampaign(this.getNextDoorAPIAuth(), campaignId);
    }

    public NextDoorAPIUpdateCampaignStatus updateCampaignStatus(String campaignId) {
        return new NextDoorAPIUpdateCampaignStatus(this.getNextDoorAPIAuth(), campaignId);
    }

    public static class NextDoorAPICreateCampaign extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private String advertiserId;

        public NextDoorAPICreateCampaign(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Campaign.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateCampaign setAdvertiserId(String advertiserId) {
            this.advertiserId = advertiserId;
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPICreateCampaign setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateCampaign setObjective(Campaign.Objective objective) {
            this.setParamInternal("objective", objective.name());

            return this;
        }

        @Override
        public Campaign execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignCreationException("Can't create campaign for advertiser " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.advertiserId, "advertiser_id");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("name"), "name");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("objective"), "objective");
        }

        public static class CampaignCreationException extends APIRequestException {
            public CampaignCreationException() {
            }

            public CampaignCreationException(String s) {
                super(s);
            }

            public CampaignCreationException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignCreationException(Throwable throwable) {
                super(throwable);
            }

            public CampaignCreationException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIUpdateCampaign extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private String advertiserId;
        private final String campaignId;

        public NextDoorAPIUpdateCampaign(NextDoorAPIAuth nextDoorAPIAuth, String campaignId) {
            super(Campaign.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(campaignId, "campaignId");
            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");

            this.setParamInternal("id", campaignId);

            this.campaignId = campaignId;
        }

        public NextDoorAPIUpdateCampaign setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);
            this.advertiserId = advertiserId;

            return this;
        }

        public NextDoorAPIUpdateCampaign setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIUpdateCampaign setObjective(Campaign.Objective objective) {
            this.setParamInternal("objective", objective.name());

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/update";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.advertiserId, "advertiser_id");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("name"), "name");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("objective"), "objective");
        }

        @Override
        public Campaign execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignUpdateException("Can't update campaign (" + this.campaignId + ") for advertiser " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class CampaignUpdateException extends APIRequestException {
            public CampaignUpdateException() {
            }

            public CampaignUpdateException(String s) {
                super(s);
            }

            public CampaignUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignUpdateException(Throwable throwable) {
                super(throwable);
            }

            public CampaignUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIUpdateCampaignStatus extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private final String campaignId;
        private String advertiserId;

        public NextDoorAPIUpdateCampaignStatus(NextDoorAPIAuth nextDoorAPIAuth, String campaignId) {
            super(Campaign.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(campaignId, "campaignId");

            this.setParamInternal("id", campaignId);

            this.campaignId = campaignId;
        }

        public NextDoorAPIUpdateCampaignStatus setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);
            this.advertiserId = advertiserId;

            return this;
        }

        public NextDoorAPIUpdateCampaignStatus setUserStatus(UserStatus userStatus) {
            this.setParamInternal("user_status", userStatus.name());

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/status/update";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.advertiserId, "advertiserId");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("user_status"), "user_status");
        }

        @Override
        public Campaign execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignStatusUpdateException("Can't update campaign (" + this.campaignId + ") status for advertiser " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class CampaignStatusUpdateException extends APIRequestException {
            public CampaignStatusUpdateException() {
            }

            public CampaignStatusUpdateException(String s) {
                super(s);
            }

            public CampaignStatusUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignStatusUpdateException(Throwable throwable) {
                super(throwable);
            }

            public CampaignStatusUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
