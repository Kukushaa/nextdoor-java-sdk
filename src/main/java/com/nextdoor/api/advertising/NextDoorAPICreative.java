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
import com.nextdoor.models.advertising.creative.AdCreative;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.UserStatus;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

import java.util.Collection;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPICreative extends NextDoorAPIRequestNode {
    public NextDoorAPICreative() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPICreative(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateCreative createCreative() {
        return new NextDoorAPICreateCreative(this.nextDoorAPIAuth);
    }

    public NextDoorAPIUpdateCreative updateCreative() {
        return new NextDoorAPIUpdateCreative(this.nextDoorAPIAuth);
    }

    public NextDoorAPICreativeStatusUpdate updateCreativeStatus() {
        return new NextDoorAPICreativeStatusUpdate(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPICreateCreative extends NextDoorAPIRequest<AdCreative> implements NextDoorAPIExecute<AdCreative> {
        public NextDoorAPICreateCreative(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdCreative.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateCreative setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateCreative setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPICreateCreative setPlacement(String placement) {
            this.setParamInternal("placement", placement);

            return this;
        }

        public NextDoorAPICreateCreative setAdvertiserName(String advertiserName) {
            this.setParamInternal("advertiser_name", advertiserName);

            return this;
        }

        public NextDoorAPICreateCreative setHeadline(String headline) {
            this.setParamInternal("headline", headline);

            return this;
        }

        public NextDoorAPICreateCreative setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateCreative setOfferText(String offerText) {
            this.setParamInternal("offer_text", offerText);

            return this;
        }

        public NextDoorAPICreateCreative setPrice(String price) {
            this.setParamInternal("price", price);

            return this;
        }

        public NextDoorAPICreateCreative setPrice(double price) {
            this.setParamInternal("price", String.valueOf(price));

            return this;
        }

        public NextDoorAPICreateCreative setCTA(String cta) {
            this.setParamInternal("cta", cta);

            return this;
        }

        public NextDoorAPICreateCreative setCanvasImageId(String canvasImageId) {
            this.setParamInternal("canvas_image_id", canvasImageId);

            return this;
        }

        public NextDoorAPICreateCreative setLogoImageId(String logoImageId) {
            this.setParamInternal("logo_image_id", logoImageId);

            return this;
        }

        public NextDoorAPICreateCreative setClickthroughUrl(String clickthroughUrl) {
            this.setParamInternal("clickthrough_url", clickthroughUrl);

            return this;
        }

        public NextDoorAPICreateCreative setImpressionTrackingUr(Collection<String> impressionTrackingUrls) {
            this.setParamInternal("impression_tracking_urls", impressionTrackingUrls);

            return this;
        }

        public NextDoorAPICreateCreative setClickTrackingUrls(Collection<String> clickTrackingUrls) {
            this.setParamInternal("click_tracking_urls", clickTrackingUrls);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "creative/create";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdCreative execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new AdCreativeCreationException("Cannot create creative because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdCreativeCreationException extends APIRequestException {
            public AdCreativeCreationException() {
            }

            public AdCreativeCreationException(String s) {
                super(s);
            }

            public AdCreativeCreationException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdCreativeCreationException(Throwable throwable) {
                super(throwable);
            }

            public AdCreativeCreationException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIUpdateCreative extends NextDoorAPIRequest<AdCreative> implements NextDoorAPIExecute<AdCreative> {
        public NextDoorAPIUpdateCreative(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdCreative.class, nextDoorAPIAuth);
        }

        public NextDoorAPIUpdateCreative setId(String id) {
            this.setParamInternal("id", id);

            return this;
        }

        public NextDoorAPIUpdateCreative setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIUpdateCreative setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIUpdateCreative setAdvertiserName(String advertiserName) {
            this.setParamInternal("advertiser_name", advertiserName);

            return this;
        }

        public NextDoorAPIUpdateCreative setHeadline(String headline) {
            this.setParamInternal("headline", headline);

            return this;
        }

        public NextDoorAPIUpdateCreative setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIUpdateCreative setOfferText(String offerText) {
            this.setParamInternal("offer_text", offerText);

            return this;
        }

        public NextDoorAPIUpdateCreative setPrice(String price) {
            this.setParamInternal("price", price);

            return this;
        }

        public NextDoorAPIUpdateCreative setCTA(String cta) {
            this.setParamInternal("cta", cta);

            return this;
        }

        public NextDoorAPIUpdateCreative setCanvasImageId(String canvasImageId) {
            this.setParamInternal("canvas_image_id", canvasImageId);

            return this;
        }

        public NextDoorAPIUpdateCreative setLogoImageId(String logoImageId) {
            this.setParamInternal("logo_image_id", logoImageId);

            return this;
        }

        public NextDoorAPIUpdateCreative setClickthroughUrl(String clickthroughUrl) {
            this.setParamInternal("clickthrough_url", clickthroughUrl);

            return this;
        }

        public NextDoorAPIUpdateCreative setImpressionTrackingUr(Collection<String> impressionTrackingUrls) {
            this.setParamInternal("impression_tracking_urls", impressionTrackingUrls);

            return this;
        }

        public NextDoorAPIUpdateCreative setClickTrackingUrls(Collection<String> clickTrackingUrls) {
            this.setParamInternal("click_tracking_urls", clickTrackingUrls);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "creative/update";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdCreative execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new AdCreativeUpdateException("Cannot create creative because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdCreativeUpdateException extends APIRequestException {
            public AdCreativeUpdateException() {
            }

            public AdCreativeUpdateException(String s) {
                super(s);
            }

            public AdCreativeUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdCreativeUpdateException(Throwable throwable) {
                super(throwable);
            }

            public AdCreativeUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPICreativeStatusUpdate extends NextDoorAPIRequest<AdCreative> implements NextDoorAPIExecute<AdCreative> {
        public NextDoorAPICreativeStatusUpdate(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdCreative.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreativeStatusUpdate setId(String id) {
            this.setParamInternal("id", id);

            return this;
        }

        public NextDoorAPICreativeStatusUpdate setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPICreativeStatusUpdate setUserStatus(UserStatus userStatus) {
            this.setParamInternal("user_status", userStatus.name());

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "creative/status/update";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdCreative execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdCreativeStatusUpdateException("Can't update Ad creative status, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdCreativeStatusUpdateException extends APIRequestException {
            public AdCreativeStatusUpdateException() {
            }

            public AdCreativeStatusUpdateException(String s) {
                super(s);
            }

            public AdCreativeStatusUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdCreativeStatusUpdateException(Throwable throwable) {
                super(throwable);
            }

            public AdCreativeStatusUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
