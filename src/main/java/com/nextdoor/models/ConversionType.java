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
