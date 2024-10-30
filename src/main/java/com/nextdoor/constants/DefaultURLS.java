package com.nextdoor.constants;

public class DefaultURLS {
    public static final String SLASH = "/";
    public static final String DEFAULT_URL = "https://nextdoor.com/";
    public static final String DEFAULT_ADS_URL = "https://ads.nextdoor.com/";
    public static final String AUTH_URL = "https://auth.nextdoor.com/";
    public static final String DEFAULT_VERSION = "v2";
    public static final String VERSION_1 = "v1";
    public static final String DEFAULT_API_PREFIX = "api";
    public static final String DEFAULT_API_EXTERNAL = "external";
    public static final String DEFAULT_API_PARTNER = "partner";
    public static final String DEFAULT_FULL_ADS_API_URL;
    public static final String DEFAULT_AUTH_FULL_API_URL;
    public static final String DEFAULT_FULL_EXTERNAL_API_URL;

    static {
        DEFAULT_FULL_ADS_API_URL = DEFAULT_ADS_URL + DEFAULT_VERSION + SLASH + DEFAULT_API_PREFIX + SLASH;
        DEFAULT_AUTH_FULL_API_URL = AUTH_URL + DEFAULT_VERSION + SLASH;
        DEFAULT_FULL_EXTERNAL_API_URL = DEFAULT_URL + DEFAULT_API_EXTERNAL + SLASH + DEFAULT_API_PREFIX + SLASH + DEFAULT_API_PARTNER + SLASH + VERSION_1 + SLASH;
    }
}
