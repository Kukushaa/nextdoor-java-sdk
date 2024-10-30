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

    //TODO: Refactor method -- ??
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
