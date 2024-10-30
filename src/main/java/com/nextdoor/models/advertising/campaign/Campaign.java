package com.nextdoor.models.advertising.campaign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.UserStatus;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Campaign extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("objective")
    private String objective;

    @JsonProperty("status")
    private String status;

    @JsonProperty("user_status")
    private UserStatus userStatus;

    @JsonProperty("start_time")
    private Date startTime;

    @JsonProperty("end_time")
    private Date endTime;

    public Campaign() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public enum Objective {
        AWARENESS,
        CONSIDERATION
    }

    public static Campaign findById(NextDoorAPIAuth nextDoorAPIAuth, String id) throws APIRequestException {
        return new NextDoorAPIFindCampaignById(nextDoorAPIAuth, id).execute();
    }

    public static NextDoorAPIFindCampaignStatsById findStatsById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
        return new NextDoorAPIFindCampaignStatsById(nextDoorAPIAuth, id);
    }

    static class NextDoorAPIFindCampaignById extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private final String id;

        public NextDoorAPIFindCampaignById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(Campaign.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/get/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Campaign execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new CampaignNotFoundException("Can't find campaign by id " + this.id + " because of: " + e.getLocalizedMessage());
            }
        }

        public static class CampaignNotFoundException extends APIRequestException {
            public CampaignNotFoundException() {
            }

            public CampaignNotFoundException(String s) {
                super(s);
            }

            public CampaignNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public CampaignNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIFindCampaignStatsById extends NextDoorAPIRequest<CampaignStatsById> implements NextDoorAPIExecute<CampaignStatsById> {
        private final String campaignId;

        public NextDoorAPIFindCampaignStatsById(NextDoorAPIAuth nextDoorAPIAuth, String campaignId) {
            super(CampaignStatsById.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(campaignId, "campaignId");

            this.campaignId = campaignId;
        }

        public NextDoorAPIFindCampaignStatsById setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIFindCampaignStatsById setStartTime(Date startTime) {
            return setStartTime(NextDoorUtil.formatDate(startTime));
        }

        public NextDoorAPIFindCampaignStatsById setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIFindCampaignStatsById setEndTime(Date endTime) {
            return setEndTime(NextDoorUtil.formatDate(endTime));
        }

        public NextDoorAPIFindCampaignStatsById setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        @Override
        protected String getPath() {
            return "campaign/get/" + this.campaignId + "/stats";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public CampaignStatsById execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignStatsNotFound("Can't find campaign stats by ID " + this.campaignId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class CampaignStatsNotFound extends APIRequestException {
            public CampaignStatsNotFound() {
            }

            public CampaignStatsNotFound(String s) {
                super(s);
            }

            public CampaignStatsNotFound(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignStatsNotFound(Throwable throwable) {
                super(throwable);
            }

            public CampaignStatsNotFound(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
