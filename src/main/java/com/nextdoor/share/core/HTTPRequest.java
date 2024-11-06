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
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.HTTPRequestFailureException;
import com.nextdoor.internal.DataParser;
import com.nextdoor.internal.HttpClient;
import com.nextdoor.models.ConversionType;
import com.nextdoor.util.NextDoorUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public abstract class HTTPRequest {
    private static final String UTF_8 = "UTF-8";

    private Map<String, Object> params = new HashMap<>();
    private Map<String, String> additionalHeaders = new HashMap<>();
    private Map<String, String> queryString = new HashMap<>();

    protected final DataParser dataParser = new DataParser();
    protected final HttpClient httpClient = new HttpClient();
    protected final NextDoorAPIAuth nextDoorAPIAuth;

    public HTTPRequest(NextDoorAPIAuth nextDoorAPIAuth, boolean isAutoHeadersForAPIAuth) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
        if (isAutoHeadersForAPIAuth) {
            this.additionalHeaders.putAll(nextDoorAPIAuth.getTokenHeader());
        }
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public Map<String, String> getQueryString() {
        return queryString;
    }

    public void addHeader(String key, String value) {
        this.additionalHeaders.put(key, value);
    }

    public void setParamInternal(String param, Object value) {
        this.params.put(param, value);
    }

    public NextDoorAPIAuth getNextDoorAPIAuth() {
        return nextDoorAPIAuth;
    }

    protected void setParamInternal(Map<String, Object> params) {
        this.params.putAll(params);
    }

    protected void writeParamInternal(Map<String, Object> params) {
        this.params = params;
    }

    protected boolean containsParamInternal(String param) {
        return this.params.containsKey(param);
    }

    protected void removeParamInternal(String param) {
        this.params.remove(param);
    }

    protected Object getParamInternal(String param) {
        return this.params.get(param);
    }

    protected String getQueryString(String key) {
        return this.queryString.get(key);
    }

    protected void addHeader(Map<String, String> additionalHeaders) {
        this.additionalHeaders.putAll(additionalHeaders);
    }

    protected void writeHeader(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }

    protected void addQueryString(String key, String value) {
        this.queryString.put(key, value);
    }

    protected void addQueryString(String key, Object value) {
        addQueryString(key, String.valueOf(value));
    }

    protected void addQueryString(Map<String, String> queryString) {
        this.queryString.putAll(queryString);
    }

    protected void writeParameters(Map<String, String> queryString) {
        this.queryString = queryString;
    }

    protected boolean existsParam(String key) {
        return this.queryString.containsKey(key);
    }

    protected void replaceParam(String key, String value) {
        this.queryString.replace(key, value);
    }

    protected void checkAndReplaceOrAddParameter(String key, String value) {
        if (this.existsParam(key)) {
            this.replaceParam(key, value);
            return;
        }

        this.addQueryString(key, value);
    }

    protected void validateParams(String... params) {
        for (String param : params) {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal(param), param);
        }
    }

    protected void clearAllMaps() {
        this.params.clear();
        this.additionalHeaders.clear();
        this.queryString.clear();
    }

    protected void addAdditionalPostRequestHeaders(ConversionType conversionType) {
        this.getAdditionalHeaders().putAll(httpClient.getHeadersByConversionType(conversionType));
    }

    protected String getBody(ConversionType conversionType) throws UnsupportedEncodingException, DataParser.DataParserException {
        switch (conversionType) {
            case URL_ENCODED:
                return this.toUrlEncodedString(this.getParams());
            case JSON:
                return this.dataParser.convertObjectToJsonString(this.getParams());
        }

        return null;
    }

    protected String setQueryStrings(String url) throws UnsupportedEncodingException {
        StringBuilder urlWithParams = new StringBuilder(url);

        if (!this.queryString.isEmpty()) {
            urlWithParams.append("?");
            for (Map.Entry<String, String> entry : this.queryString.entrySet()) {
                urlWithParams.append(URLEncoder.encode(entry.getKey(), UTF_8)).append("=").append(URLEncoder.encode(entry.getValue(), UTF_8)).append("&");
            }

            // Remove the last '&' character
            urlWithParams.deleteCharAt(urlWithParams.length() - 1);
        }

        return urlWithParams.toString();
    }

    protected JsonNode sendAndReturnResponse(String path, HttpMethod httpMethod, ConversionType conversionType) throws APIRequestException {
        this.nextDoorAPIAuth.log("======================= NEXTDOOR API {0} START =======================", httpMethod);

        String fullUrl;
        try {
            fullUrl = setQueryStrings(path);
        } catch (UnsupportedEncodingException e) {
            throw new APIRequestException(e);
        }

        this.nextDoorAPIAuth.log("Sending HTTP {0} request to {1}", httpMethod, fullUrl);

        HttpResponse<JsonNode> response = getHttpResponseJsonNode(httpMethod, fullUrl, conversionType);

        this.clearAllMaps();

        int status = response.getStatus();
        this.nextDoorAPIAuth.log("HTTP Request sended with status {0}", status);

        JsonNode body = response.getBody();
        String responseJsonAsString = body.toString();

        if (status != 200) {
            this.nextDoorAPIAuth.log("======================= NEXTDOOR API {0} FAILED =======================", httpMethod);
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + responseJsonAsString);
        }

        this.nextDoorAPIAuth.log("Ended successfully, converting to JSON {0}", responseJsonAsString);
        this.nextDoorAPIAuth.log("======================= NEXTDOOR API {0} ENDED SUCCESSFULLY =======================", httpMethod);

        return body;
    }

    protected String toUrlEncodedString(Map<String, Object> map) throws UnsupportedEncodingException {
        StringJoiner stringJoiner = new StringJoiner("&");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            stringJoiner.add(URLEncoder.encode(entry.getKey(), UTF_8) + "=" + URLEncoder.encode(entry.getValue().toString(), UTF_8));
        }
        return stringJoiner.toString();
    }

    private HttpResponse<JsonNode> getHttpResponseJsonNode(HttpMethod httpMethod, String path, ConversionType conversionType) throws HTTPRequestFailureException {
        try {
            switch (httpMethod) {
                case DELETE:
                case PUT:
                case POST: {
                    addAdditionalPostRequestHeaders(conversionType);
                    return httpClient.sendRequestWithBody(path, getBody(conversionType), this.getAdditionalHeaders());
                }
                case GET:
                    if (conversionType == ConversionType.JSON) {
                        addAdditionalPostRequestHeaders(conversionType);
                        return httpClient.sendRequestWithBody(path, getBody(conversionType), this.getAdditionalHeaders());
                    }
                    return httpClient.sendGetRequest(path, this.getAdditionalHeaders());
                default:
                    throw new RuntimeException("Unsupported HTTP method");
            }
        } catch (UnirestException | RuntimeException | UnsupportedEncodingException |
                 DataParser.DataParserException e) {
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + e.getLocalizedMessage());
        }
    }
}
