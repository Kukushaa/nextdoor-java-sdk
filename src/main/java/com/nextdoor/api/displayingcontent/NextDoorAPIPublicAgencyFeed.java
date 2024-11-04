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
package com.nextdoor.api.displayingcontent;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.displayingcontent.publicagencyfeed.AgencyPosts;
import com.nextdoor.models.displayingcontent.publicagencyfeed.LocationListByState;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_URL;

public class NextDoorAPIPublicAgencyFeed extends NextDoorAPIRequestNode {
    public NextDoorAPIPublicAgencyFeed() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIPublicAgencyFeed(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public static class NextDoorAPIAgencyListByState extends NextDoorAPIRequest<LocationListByState> implements NextDoorAPIExecute<LocationListByState> {
        private String stateId;

        public NextDoorAPIAgencyListByState(NextDoorAPIAuth nextDoorAPIAuth) {
            super(LocationListByState.class, nextDoorAPIAuth);
        }

        public NextDoorAPIAgencyListByState setStateId(String stateId) {
            this.stateId = stateId;

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/agency_list/" + this.stateId;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.stateId, "stateID");
        }

        @Override
        public LocationListByState execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new LocationListByStateNotFoundException("Can't find location list by state " + this.stateId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class LocationListByStateNotFoundException extends APIRequestException {
            public LocationListByStateNotFoundException() {
            }

            public LocationListByStateNotFoundException(String s) {
                super(s);
            }

            public LocationListByStateNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public LocationListByStateNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public LocationListByStateNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIPostsForAnAgency extends NextDoorAPIRequest<AgencyPosts> implements NextDoorAPIExecute<AgencyPosts> {
        private String id;

        public NextDoorAPIPostsForAnAgency(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AgencyPosts.class, nextDoorAPIAuth);
        }

        public NextDoorAPIPostsForAnAgency setId(String id) {
            this.id = id;

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/agency_digest/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.id, "ID");
        }

        @Override
        public AgencyPosts execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AgencyPostsNotFoundException("Can't find agency posts by ID " + this.id + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AgencyPostsNotFoundException extends APIRequestException {
            public AgencyPostsNotFoundException() {
            }

            public AgencyPostsNotFoundException(String s) {
                super(s);
            }

            public AgencyPostsNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AgencyPostsNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AgencyPostsNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
