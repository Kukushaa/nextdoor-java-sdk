package com.nextdoor.models.advertising.reporting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdReporting extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("download_url")
    private String downloadUrl;

    public AdReporting() {

    }

    public AdReporting(String id, String advertiserId, String name, String downloadUrl) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.name = name;
        this.downloadUrl = downloadUrl;
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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "AdReporting{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", name='" + name + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }

    public static AdReporting findById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIGetReportingById(nextDoorAPIAuth, id).execute();
    }

    static class NextDoorAPIGetReportingById extends NextDoorAPIRequest<AdReporting> implements NextDoorAPIExecute<AdReporting> {
        private final String id;

        public NextDoorAPIGetReportingById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(AdReporting.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "reporting/get/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdReporting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AdReportingNotFoundException("Cannot find AdReporting with id: " + this.id + " because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdReportingNotFoundException extends APIRequestException {
            public AdReportingNotFoundException() {
            }

            public AdReportingNotFoundException(String s) {
                super(s);
            }

            public AdReportingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdReportingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdReportingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}