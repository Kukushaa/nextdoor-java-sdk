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
package com.nextdoor.api.displayingcontent;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.*;
import com.nextdoor.models.displayingcontent.search.*;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.share.interfaces.NextDoorAPIExecuteList;
import com.nextdoor.util.NextDoorUtil;

import java.util.Date;
import java.util.List;

public class NextDoorAPISearch extends NextDoorAPIRequestNode {
    public NextDoorAPISearch() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPISearch(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPISearchPosts searchPosts() {
        return new NextDoorAPISearchPosts(this.nextDoorAPIAuth);
    }

    public NextDoorAPISearchPostsBySignals searchPostsBySignals() {
        return new NextDoorAPISearchPostsBySignals(this.nextDoorAPIAuth);
    }

    public NextDoorAPISearchFSFItems searchFSFItems() {
        return new NextDoorAPISearchFSFItems(this.nextDoorAPIAuth);
    }

    public NextDoorAPISearchEvents searchEvents() {
        return new NextDoorAPISearchEvents(this.nextDoorAPIAuth);
    }

    public NextDoorAPISearchBusinesses searchBusinesses() {
        return new NextDoorAPISearchBusinesses(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPISearchPosts extends NextDoorAPIRequest<SearchPosts> implements NextDoorAPIExecute<SearchPosts> {
        public NextDoorAPISearchPosts(NextDoorAPIAuth nextDoorAPIAuth) {
            super(SearchPosts.class, nextDoorAPIAuth);
        }

        public NextDoorAPISearchPosts setLatitude(float latitude) {
            this.addParameters("lat", latitude);

            return this;
        }

        public NextDoorAPISearchPosts setLongitude(float longitude) {
            this.addParameters("lon", longitude);

            return this;
        }

        public NextDoorAPISearchPosts setRadius(float radius) {
            this.addParameters("radius", radius);

            return this;
        }

        public NextDoorAPISearchPosts setQuery(String query) {
            this.addParameters("query", query);

            return this;
        }

        public NextDoorAPISearchPosts setIncludeComments(boolean includeComments) {
            this.addParameters("include_comments", includeComments);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_URL + "content_api/v2/search_post";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("lat"), "lat");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("lon"), "lon");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("radius"), "radius");
        }

        @Override
        public SearchPosts execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new SearchPostsNotFoudException("Can't search posts, because of: " + e.getLocalizedMessage());
            }
        }

        public static class SearchPostsNotFoudException extends APIRequestException {
            public SearchPostsNotFoudException() {
            }

            public SearchPostsNotFoudException(String s) {
                super(s);
            }

            public SearchPostsNotFoudException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public SearchPostsNotFoudException(Throwable throwable) {
                super(throwable);
            }

            public SearchPostsNotFoudException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPISearchPostsBySignals extends NextDoorAPIRequest<SearchPostsBySignals> implements NextDoorAPIExecute<SearchPostsBySignals> {
        public NextDoorAPISearchPostsBySignals(NextDoorAPIAuth nextDoorAPIAuth) {
            super(SearchPostsBySignals.class, nextDoorAPIAuth);
        }

        public NextDoorAPISearchPostsBySignals setContentType(ContentType contentType) {
            this.addParameters("content_type", contentType.name());

            return this;
        }

        public NextDoorAPISearchPostsBySignals setIsodate(Date date) {
            this.addParameters("isodate", date.toString());

            return this;
        }

        public NextDoorAPISearchPostsBySignals setIsodate(String date) {
            this.addParameters("isodate", date);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_URL + "content_api/v1/content_understanding";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public SearchPostsBySignals execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new SearchPostsBySignalsNotFoundException("Can't search post by signals, because of: " + e.getLocalizedMessage());
            }
        }

        public static class SearchPostsBySignalsNotFoundException extends APIRequestException {
            public SearchPostsBySignalsNotFoundException() {
            }

            public SearchPostsBySignalsNotFoundException(String s) {
                super(s);
            }

            public SearchPostsBySignalsNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public SearchPostsBySignalsNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public SearchPostsBySignalsNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPISearchFSFItems extends NextDoorAPIRequest<SearchFSFItems> implements NextDoorAPIExecuteList<SearchFSFItems> {
        public NextDoorAPISearchFSFItems(NextDoorAPIAuth nextDoorAPIAuth) {
            super(SearchFSFItems.class, nextDoorAPIAuth);
        }

        public NextDoorAPISearchFSFItems setLatitude(float latitude) {
            this.addParameters("lat", latitude);

            return this;
        }

        public NextDoorAPISearchFSFItems setLongitude(float longitude) {
            this.addParameters("lon", longitude);

            return this;
        }

        public NextDoorAPISearchFSFItems setRadius(float radius) {
            this.addParameters("radius", radius);

            return this;
        }

        public NextDoorAPISearchFSFItems setQuery(String query) {
            this.addParameters("query", query);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_URL + "content_api/v2/search_sale_item";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("lat"), "lat");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("lon"), "lon");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("radius"), "radius");
        }

        @Override
        public List<SearchFSFItems> execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequestForList(HttpMethod.GET, getPath(), ConversionType.URL_ENCODED);
            } catch (APIRequestException e) {
                throw new SearchFSFItemsException("Can't search FSF items, because of: " + e.getLocalizedMessage());
            }
        }

        public static class SearchFSFItemsException extends APIRequestException {
            public SearchFSFItemsException() {
            }

            public SearchFSFItemsException(String s) {
                super(s);
            }

            public SearchFSFItemsException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public SearchFSFItemsException(Throwable throwable) {
                super(throwable);
            }

            public SearchFSFItemsException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPISearchEvents extends NextDoorAPIRequest<SearchEvents> implements NextDoorAPIExecuteList<SearchEvents> {
        public NextDoorAPISearchEvents(NextDoorAPIAuth nextDoorAPIAuth) {
            super(SearchEvents.class, nextDoorAPIAuth);
        }

        public NextDoorAPISearchEvents setLatitude(float latitude) {
            this.addParameters("lat", latitude);

            return this;
        }

        public NextDoorAPISearchEvents setLongitude(float longitude) {
            this.addParameters("lon", longitude);

            return this;
        }

        public NextDoorAPISearchEvents setRadius(float radius) {
            this.addParameters("radius", radius);

            return this;
        }

        public NextDoorAPISearchEvents setQuery(String query) {
            this.addParameters("query", query);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_URL + "content_api/v2/search_event";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("lat"), "lat");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("lon"), "lon");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("radius"), "radius");
        }

        @Override
        public List<SearchEvents> execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequestForList(HttpMethod.GET, getPath(), ConversionType.URL_ENCODED);
            } catch (APIRequestException e) {
                throw new SearchEventsException("Can't search events, because of: " + e.getLocalizedMessage());
            }
        }

        public static class SearchEventsException extends APIRequestException {
            public SearchEventsException() {
            }

            public SearchEventsException(String s) {
                super(s);
            }

            public SearchEventsException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public SearchEventsException(Throwable throwable) {
                super(throwable);
            }

            public SearchEventsException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPISearchBusinesses extends NextDoorAPIRequest<SearchBusinesses> implements NextDoorAPIExecuteList<SearchBusinesses> {
        public NextDoorAPISearchBusinesses(NextDoorAPIAuth nextDoorAPIAuth) {
            super(SearchBusinesses.class, nextDoorAPIAuth);
        }

        public NextDoorAPISearchBusinesses setLatitude(float latitude) {
            this.addParameters("lat", latitude);

            return this;
        }

        public NextDoorAPISearchBusinesses setLongitude(float longitude) {
            this.addParameters("lon", longitude);

            return this;
        }

        public NextDoorAPISearchBusinesses setRadius(float radius) {
            this.addParameters("radius", radius);

            return this;
        }

        public NextDoorAPISearchBusinesses setQuery(String query) {
            this.addParameters("query", query);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_URL + "content_api/v2/search_business";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("lat"), "lat");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("lon"), "lon");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("radius"), "radius");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("query"), "query");
        }

        @Override
        public List<SearchBusinesses> execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequestForList(HttpMethod.GET, getPath(), ConversionType.URL_ENCODED);
            } catch (APIRequestException e) {
                throw new SearchBusinessesNotFoundException("Can't search businesses, because of: " + e.getLocalizedMessage());
            }
        }

        public static class SearchBusinessesNotFoundException extends APIRequestException {
            public SearchBusinessesNotFoundException() {
            }

            public SearchBusinessesNotFoundException(String s) {
                super(s);
            }

            public SearchBusinessesNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public SearchBusinessesNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public SearchBusinessesNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
