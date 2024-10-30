package com.nextdoor.internal;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.models.ConversionType;

import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    public HttpResponse<JsonNode> sendRequestWithBody(String url, String body, Map<String, String> headers) throws UnirestException {
        return Unirest.post(url)
                .headers(headers)
                .body(body)
                .asJson();
    }

    public HttpResponse<JsonNode> sendGetRequest(String url, Map<String, String> headers) throws UnirestException {
        Map<String, String> allHeaders = new HashMap<>(headers);
        allHeaders.putAll(this.getDefaultHeadersForGetRequest());

        return Unirest.get(url)
                .headers(allHeaders)
                .asJson();
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