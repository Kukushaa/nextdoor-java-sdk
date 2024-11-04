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
package com.nextdoor.share.core;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.HTTPRequestFailureException;
import com.nextdoor.internal.DataParser;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.NextDoorModel;

import java.util.List;

public abstract class NextDoorAPIRequest<T extends NextDoorModel> extends HTTPRequest {
    private final Class<T> responseClass;

    public NextDoorAPIRequest(Class<T> responseClass, NextDoorAPIAuth nextDoorAPIAuth) {
        this(responseClass, nextDoorAPIAuth, true);
    }

    public NextDoorAPIRequest(Class<T> responseClass, NextDoorAPIAuth nextDoorAPIAuth, boolean isAutoHeadersForAPIAuth) {
        super(nextDoorAPIAuth, isAutoHeadersForAPIAuth);
        this.responseClass = responseClass;
    }

    protected T sendHttpRequest(HttpMethod httpMethod) throws APIRequestException {
        return sendHttpRequest(httpMethod, getPath());
    }

    protected T sendHttpRequest(HttpMethod httpMethod, ConversionType conversionType) throws APIRequestException {
        return sendHttpRequest(httpMethod, getPath(), conversionType);
    }

    protected T sendHttpRequest(HttpMethod httpMethod, String path) throws APIRequestException {
        return sendHttpRequest(httpMethod, path, ConversionType.fromHTTPMethod(httpMethod));
    }

    protected T sendHttpRequest(HttpMethod httpMethod, String path, ConversionType conversionType) throws APIRequestException {
        try {
            return dataParser.parseToObject(sendAndReturnResponse(path, httpMethod, conversionType).toString(), this.responseClass);
        } catch (DataParser.DataParserException e) {
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + e.getLocalizedMessage());
        }
    }

    protected List<T> sendHttpRequestForList(HttpMethod httpMethod, String path, ConversionType conversionType) throws APIRequestException {
        try {
            return dataParser.parseToList(sendAndReturnResponse(path, httpMethod, conversionType).toString(), this.responseClass);
        } catch (DataParser.DataParserException e) {
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + e.getLocalizedMessage());
        }
    }

    protected abstract String getPath();

    protected abstract void validateRequiredParams();
}
