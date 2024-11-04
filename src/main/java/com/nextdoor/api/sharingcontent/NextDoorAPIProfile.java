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
package com.nextdoor.api.sharingcontent;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.sharingcontent.profile.Profiles;
import com.nextdoor.models.sharingcontent.profile.Profile;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

public class NextDoorAPIProfile extends NextDoorAPIRequestNode {
    public NextDoorAPIProfile() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIProfile(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIPublishProfileInfo getProfileInfo() {
        return new NextDoorAPIPublishProfileInfo(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIPublishProfilesInfo getProfiles() {
        return new NextDoorAPIPublishProfilesInfo(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPIPublishProfileInfo extends NextDoorAPIRequest<Profile> implements NextDoorAPIExecute<Profile> {
        public NextDoorAPIPublishProfileInfo(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Profile.class, nextDoorAPIAuth);
        }

        @Override
        public Profile execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new ProifleGetException("Can't get profile info for: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL + "me";
        }

        @Override
        protected void validateRequiredParams() {

        }

        public static class ProifleGetException extends APIRequestException {
            public ProifleGetException() {
            }

            public ProifleGetException(String s) {
                super(s);
            }

            public ProifleGetException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public ProifleGetException(Throwable throwable) {
                super(throwable);
            }

            public ProifleGetException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIPublishProfilesInfo extends NextDoorAPIRequest<Profiles> implements NextDoorAPIExecute<Profiles> {
        public NextDoorAPIPublishProfilesInfo(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Profiles.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL + "me/profiles";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Profiles execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new ProfilesGetException("Can't get profiles list from the API for: " + e.getLocalizedMessage());
            }
        }

        public static class ProfilesGetException extends APIRequestException {
            public ProfilesGetException() {
            }

            public ProfilesGetException(String s) {
                super(s);
            }

            public ProfilesGetException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public ProfilesGetException(Throwable throwable) {
                super(throwable);
            }

            public ProfilesGetException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
