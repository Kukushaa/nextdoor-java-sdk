package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.AccessToken;
import com.nextdoor.models.ConversionType;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;
import org.apache.commons.codec.binary.Base64;

public class NextDoorAPIAccessToken {
    private final String authorizationHeader;

    public NextDoorAPIAccessToken() {
        this.authorizationHeader = "";
    }

    public NextDoorAPIAccessToken(String userName, String password) {
        NextDoorUtil.ensureStringNotNull(userName, "userName");
        NextDoorUtil.ensureStringNotNull(password, "password");

        this.authorizationHeader = this.createBasicHeaderValue(userName, password);
    }

    public NextDoorAPIAccessTokenGenerate generate() {
        return new NextDoorAPIAccessTokenGenerate(this.authorizationHeader);
    }

    public NextDoorAPIAccessTokenRefresh refresh() {
        return new NextDoorAPIAccessTokenRefresh(this.authorizationHeader);
    }

    private String createBasicHeaderValue(String userName, String password) {
        return new Base64().encodeToString((userName + ":" + password).getBytes());
    }

    public static class NextDoorAPIAccessTokenGenerate extends NextDoorAPIRequest<AccessToken> implements NextDoorAPIExecute<AccessToken> {
        public NextDoorAPIAccessTokenGenerate(String authorizationHeader) {
            super(AccessToken.class, NextDoorAPIAuth.defaultNextDoorAPIAuth(), false);
            NextDoorUtil.ensureStringNotNull(authorizationHeader, "Authorization header");

            this.addHeader("authorization", authorizationHeader);
        }

        public NextDoorAPIAccessTokenGenerate setGrantType(AccessToken.GrantType grantType) {
            this.setParamInternal("grant_type", grantType.getFormData());

            return this;
        }

        public NextDoorAPIAccessTokenGenerate setCode(String code) {
            this.setParamInternal("code", code);

            return this;
        }

        public NextDoorAPIAccessTokenGenerate setClientId(String clientId) {
            this.setParamInternal("client_id", clientId);

            return this;
        }

        public NextDoorAPIAccessTokenGenerate setRedirectUri(String redirectUri) {
            this.setParamInternal("redirect_uri", redirectUri);

            return this;
        }

        @Override
        public AccessToken execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.URL_ENCODED);
            } catch (APIRequestException e) {
                throw new AccessTokenCreationException("Can't generate access token because of: ", e);
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_AUTH_FULL_API_URL + "token";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("grant_type"), "grant_type");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("code"), "code");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("client_id"), "client_id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("redirect_uri"), "redirect_uri");
        }

        public static class AccessTokenCreationException extends APIRequestException {
            public AccessTokenCreationException() {
            }

            public AccessTokenCreationException(String s) {
                super(s);
            }

            public AccessTokenCreationException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AccessTokenCreationException(Throwable throwable) {
                super(throwable);
            }

            public AccessTokenCreationException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAccessTokenRefresh extends NextDoorAPIRequest<AccessToken> implements NextDoorAPIExecute<AccessToken> {
        public NextDoorAPIAccessTokenRefresh(String authorizationHeader) {
            super(AccessToken.class, NextDoorAPIAuth.defaultNextDoorAPIAuth(), false);
            NextDoorUtil.ensureStringNotNull(authorizationHeader, "Authorization header");

            this.addHeader("authorization", authorizationHeader);
        }

        public NextDoorAPIAccessTokenRefresh setGrantType(AccessToken.GrantType grantType) {
            this.setParamInternal("grant_type", grantType.getFormData());

            return this;
        }

        public NextDoorAPIAccessTokenRefresh setRefreshToken(String accessToken) {
            this.setParamInternal("refresh_token", accessToken);

            return this;
        }

        public NextDoorAPIAccessTokenRefresh setScope(String scope) {
            this.setParamInternal("scope", scope);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_AUTH_FULL_API_URL + "token";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("grant_type"), "grant_type");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("refresh_token"), "refresh_token");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("scope"), "scope");
        }

        @Override
        public AccessToken execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.URL_ENCODED);
            } catch (APIRequestException e) {
                throw new AccessTokenRefreshException("Access token can't be refreshed beacuse of: " + e.getLocalizedMessage());
            }
        }

        public static class AccessTokenRefreshException extends APIRequestException {
            public AccessTokenRefreshException() {
            }

            public AccessTokenRefreshException(String s) {
                super(s);
            }

            public AccessTokenRefreshException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AccessTokenRefreshException(Throwable throwable) {
                super(throwable);
            }

            public AccessTokenRefreshException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
