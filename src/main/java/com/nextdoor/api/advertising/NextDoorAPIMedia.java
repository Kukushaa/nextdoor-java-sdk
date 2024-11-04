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
import com.nextdoor.models.advertising.media.AdFile;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPIMedia extends NextDoorAPIRequestNode {
    public NextDoorAPIMedia() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIMedia(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDooAPIMediaLogoUpload uploadLogo() {
        return new NextDooAPIMediaLogoUpload(this.nextDoorAPIAuth);
    }

    public NextDooAPIMediaCanvasUpload uploadCanvas() {
        return new NextDooAPIMediaCanvasUpload(this.nextDoorAPIAuth);
    }

    public static class NextDooAPIMediaLogoUpload extends NextDoorAPIRequest<AdFile> implements NextDoorAPIExecute<AdFile> {
        public NextDooAPIMediaLogoUpload(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdFile.class, nextDoorAPIAuth);
        }

        public NextDooAPIMediaLogoUpload setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDooAPIMediaLogoUpload setFile(String file) {
            this.setParamInternal("file", file);

            return this;
        }

        public NextDooAPIMediaLogoUpload setFileName(String fileName) {
            this.setParamInternal("file_name", fileName);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "media/logo/upload";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdFile execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new NextDoorAPIMediaLogoUploadException("Cannot upload logo because of: " + e.getLocalizedMessage());
            }
        }

        public static class NextDoorAPIMediaLogoUploadException extends APIRequestException {
            public NextDoorAPIMediaLogoUploadException() {
            }

            public NextDoorAPIMediaLogoUploadException(String s) {
                super(s);
            }

            public NextDoorAPIMediaLogoUploadException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public NextDoorAPIMediaLogoUploadException(Throwable throwable) {
                super(throwable);
            }

            public NextDoorAPIMediaLogoUploadException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDooAPIMediaCanvasUpload extends NextDoorAPIRequest<AdFile> implements NextDoorAPIExecute<AdFile> {
        public NextDooAPIMediaCanvasUpload(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdFile.class, nextDoorAPIAuth);
        }

        public NextDooAPIMediaCanvasUpload setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDooAPIMediaCanvasUpload setPlacement(String placement) {
            this.setParamInternal("placement", placement);

            return this;
        }

        public NextDooAPIMediaCanvasUpload setFile(String file) {
            this.setParamInternal("file", file);

            return this;
        }

        public NextDooAPIMediaCanvasUpload setFileName(String fileName) {
            this.setParamInternal("file_name", fileName);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "media/canvas/upload";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdFile execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new NextDoorAPIMediaCanvasUploadException("Cannot upload canvas because of: " + e.getLocalizedMessage());
            }
        }

        public static class NextDoorAPIMediaCanvasUploadException extends APIRequestException {
            public NextDoorAPIMediaCanvasUploadException() {
            }

            public NextDoorAPIMediaCanvasUploadException(String s) {
                super(s);
            }

            public NextDoorAPIMediaCanvasUploadException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public NextDoorAPIMediaCanvasUploadException(Throwable throwable) {
                super(throwable);
            }

            public NextDoorAPIMediaCanvasUploadException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
