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
import com.nextdoor.models.advertising.user.AdUser;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

public class NextDoorAPIUser extends NextDoorAPIRequestNode {
    public NextDoorAPIUser() {

    }

    public NextDoorAPIUser(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIUserInfo getUserInfo() {
        return new NextDoorAPIUserInfo(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPIUserInfo extends NextDoorAPIRequest<AdUser> implements NextDoorAPIExecute<AdUser> {
        public NextDoorAPIUserInfo(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdUser.class, nextDoorAPIAuth);
        }

        @Override
        public AdUser execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new UserGetException("Can't get user info, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "me";
        }

        @Override
        protected void validateRequiredParams() {

        }

        public static class UserGetException extends APIRequestException {
            public UserGetException() {
            }

            public UserGetException(String s) {
                super(s);
            }

            public UserGetException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public UserGetException(Throwable throwable) {
                super(throwable);
            }

            public UserGetException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
