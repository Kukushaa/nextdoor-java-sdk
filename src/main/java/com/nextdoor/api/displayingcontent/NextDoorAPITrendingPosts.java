package com.nextdoor.api.displayingcontent;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.*;
import com.nextdoor.models.displayingcontent.trendingposts.City;
import com.nextdoor.models.displayingcontent.trendingposts.State;
import com.nextdoor.models.displayingcontent.trendingposts.TargetingPostsCity;
import com.nextdoor.models.displayingcontent.trendingposts.TargetingStateWithPagination;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.share.interfaces.NextDoorAPIExecuteList;
import com.nextdoor.util.NextDoorUtil;

import java.util.List;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_URL;

public class NextDoorAPITrendingPosts extends NextDoorAPIRequestNode {
    public NextDoorAPITrendingPosts() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPITrendingPosts(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPISearchPosts searchPosts() {
        return new NextDoorAPISearchPosts(this.nextDoorAPIAuth);
    }

    public NextDoorAPIStateList stateList() {
        return new NextDoorAPIStateList(this.nextDoorAPIAuth);
    }

    public NextDoorAPITargetingPostsForCity targetingPostsForCity() {
        return new NextDoorAPITargetingPostsForCity(this.nextDoorAPIAuth);
    }

    public NextDoorAPITargetingPostsForStateWithPagination targetingPostsForStateWithPagination() {
        return new NextDoorAPITargetingPostsForStateWithPagination(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPISearchPosts extends NextDoorAPIRequest<City> implements NextDoorAPIExecuteList<City> {
        public NextDoorAPISearchPosts(NextDoorAPIAuth nextDoorAPIAuth) {
            super(City.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/city_list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public List<City> execute() throws APIRequestException {
            try {
                return sendHttpRequestForList(HttpMethod.GET, getPath(), ConversionType.NONE);
            } catch (APIRequestException e) {
                throw new CityListFoundException("Can't get list of cities, because of: " + e.getLocalizedMessage());
            }
        }

        public static class CityListFoundException extends APIRequestException {
            public CityListFoundException() {
            }

            public CityListFoundException(String s) {
                super(s);
            }

            public CityListFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CityListFoundException(Throwable throwable) {
                super(throwable);
            }

            public CityListFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIStateList extends NextDoorAPIRequest<State> implements NextDoorAPIExecuteList<State> {
        public NextDoorAPIStateList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(State.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/state_list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public List<State> execute() throws APIRequestException {
            try {
                return sendHttpRequestForList(HttpMethod.GET, getPath(), ConversionType.NONE);
            } catch (APIRequestException e) {
                throw new StateListFindException("Can't get states list, because of: " + e.getLocalizedMessage());
            }
        }

        public static class StateListFindException extends APIRequestException {
            public StateListFindException() {
            }

            public StateListFindException(String s) {
                super(s);
            }

            public StateListFindException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public StateListFindException(Throwable throwable) {
                super(throwable);
            }

            public StateListFindException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPITargetingPostsForCity extends NextDoorAPIRequest<TargetingPostsCity> implements NextDoorAPIExecute<TargetingPostsCity> {
        private String id;

        public NextDoorAPITargetingPostsForCity(NextDoorAPIAuth nextDoorAPIAuth) {
            super(TargetingPostsCity.class, nextDoorAPIAuth);
        }

        public NextDoorAPITargetingPostsForCity setId(String id) {
            this.id = id;

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/city_digest/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.id, "ID");
        }

        @Override
        public TargetingPostsCity execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new TargetingPostsCityFoundException("Can't find targeting posts city, because of: " + e.getLocalizedMessage());
            }
        }

        public static class TargetingPostsCityFoundException extends APIRequestException {
            public TargetingPostsCityFoundException() {
            }

            public TargetingPostsCityFoundException(String s) {
                super(s);
            }

            public TargetingPostsCityFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public TargetingPostsCityFoundException(Throwable throwable) {
                super(throwable);
            }

            public TargetingPostsCityFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPITargetingPostsForStateWithPagination extends NextDoorAPIRequest<TargetingStateWithPagination> implements NextDoorAPIExecute<TargetingStateWithPagination> {
        private String stateId;
        private Integer pageNum;

        public NextDoorAPITargetingPostsForStateWithPagination(NextDoorAPIAuth nextDoorAPIAuth) {
            super(TargetingStateWithPagination.class, nextDoorAPIAuth);
        }

        public NextDoorAPITargetingPostsForStateWithPagination setStateId(String stateId) {
            this.stateId = stateId;

            return this;
        }

        public NextDoorAPITargetingPostsForStateWithPagination setPageNum(Integer pageNum) {
            this.pageNum = pageNum;

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/state_digest/" + this.stateId + "/page/" + (this.pageNum == null ? "current_page" : this.pageNum);
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.stateId, "stateID");
        }

        @Override
        public TargetingStateWithPagination execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new TargetingStateWithPaginationException("Can't find targeting state " + this.stateId + " by pagination ( " + this.pageNum + "), because of: " + e.getLocalizedMessage());
            }
        }

        public static class TargetingStateWithPaginationException extends APIRequestException {
            public TargetingStateWithPaginationException() {
            }

            public TargetingStateWithPaginationException(String s) {
                super(s);
            }

            public TargetingStateWithPaginationException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public TargetingStateWithPaginationException(Throwable throwable) {
                super(throwable);
            }

            public TargetingStateWithPaginationException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
