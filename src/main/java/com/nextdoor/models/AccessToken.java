package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken extends NextDoorModel implements Serializable {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("id_token")
    private String tokenId;

    @JsonProperty("expires_in")
    private long expiresIn;

    public AccessToken() {

    }

    public AccessToken(String accessToken, String tokenType, String tokenId, long expiresIn) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.tokenId = tokenId;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }

    public enum GrantType {
        REFRESH_TOKEN("refresh_token"),
        AUTHORIZATION_CODE("authorization_code");

        private final String formData;

        GrantType(String formData) {
            this.formData = formData;
        }

        public String getFormData() {
            return formData;
        }
    }
}
