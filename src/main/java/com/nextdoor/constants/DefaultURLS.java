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
