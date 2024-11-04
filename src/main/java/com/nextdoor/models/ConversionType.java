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
package com.nextdoor.models;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.exception.APIRequestException;

public enum ConversionType {
    NONE,
    JSON,
    URL_ENCODED;

    public static ConversionType fromHTTPMethod(HttpMethod httpMethod) throws HTTPRequestNotSupportedException {
        switch (httpMethod) {
            case GET:
                return NONE;
            case DELETE:
            case POST:
            case PUT:
                return JSON;
            default:
                throw new HTTPRequestNotSupportedException("HTTP request not supported: " + httpMethod);
        }
    }

    public static class HTTPRequestNotSupportedException extends APIRequestException {
        public HTTPRequestNotSupportedException() {
        }

        public HTTPRequestNotSupportedException(String s) {
            super(s);
        }

        public HTTPRequestNotSupportedException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public HTTPRequestNotSupportedException(Throwable throwable) {
            super(throwable);
        }

        public HTTPRequestNotSupportedException(String s, Throwable throwable, boolean b, boolean b1) {
            super(s, throwable, b, b1);
        }
    }
}
