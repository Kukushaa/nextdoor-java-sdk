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
package com.nextdoor.internal;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.models.ConversionType;

import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    public HttpResponse<String> sendRequestWithBody(String url, String body, Map<String, String> headers) throws UnirestException {
        return Unirest.post(url)
                .headers(headers)
                .body(body)
                .asString();
    }

    public HttpResponse<String> sendGetRequest(String url, Map<String, String> headers) throws UnirestException {
        Map<String, String> allHeaders = new HashMap<>(headers);
        allHeaders.putAll(this.getDefaultHeadersForGetRequest());

        return Unirest.get(url)
                .headers(allHeaders)
                .asString();
    }

    public Map<String, String> getHeadersByConversionType(ConversionType conversionType) {
        switch (conversionType) {
            case JSON:
                return this.getDefaultHeadersForJsonPostRequest();
            case URL_ENCODED:
                return this.getDefaultHeadersForUrlEncodedPostRequest();
            default:
                return new HashMap<>();
        }
    }

    private Map<String, String> getDefaultHeadersForGetRequest() {
        Map<String, String> headers = new HashMap<>();

        headers.put("accept", "application/json");

        return headers;
    }

    private Map<String, String> getDefaultHeadersForJsonPostRequest() {
        Map<String, String> headers = new HashMap<>();

        headers.put("accept", "application/json");
        headers.put("content-type", "application/json");

        return headers;
    }

    private Map<String, String> getDefaultHeadersForUrlEncodedPostRequest() {
        Map<String, String> headers = new HashMap<>();

        headers.put("accept", "application/json");
        headers.put("content-type", "application/x-www-form-urlencoded");

        return headers;
    }
}
