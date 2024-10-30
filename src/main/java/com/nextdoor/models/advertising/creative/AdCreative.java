package com.nextdoor.models.advertising.creative;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdCreative extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("placement")
    private String placement;

    @JsonProperty("advertiser_name")
    private String advertiserName;

    @JsonProperty("headline")
    private String headline;

    @JsonProperty("body_text")
    private String bodyText;

    @JsonProperty("offer_text")
    private String offerText;

    @JsonProperty("price")
    private String price;

    @JsonProperty("cta")
    private String cta;

    @JsonProperty("canvas_image_url")
    private String canvasImageUrl;

    @JsonProperty("logo_image_url")
    private String logoImageUrl;

    @JsonProperty("clickthrough_url")
    private String clickthroughUrl;

    @JsonProperty("impression_tracking_urls")
    private List<String> impressionTrackingUrls;

    @JsonProperty("click_tracking_urls")
    private List<String> clickTrackingUrls;

    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonProperty("updated_at")
    private Instant updatedAt;

    public AdCreative() {

    }

    public AdCreative(String id, String advertiserId, String name, String status, String placement, String advertiserName, String headline, String bodyText, String offerText, String price, String cta, String canvasImageUrl, String logoImageUrl, String clickthroughUrl, List<String> impressionTrackingUrls, List<String> clickTrackingUrls, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.name = name;
        this.status = status;
        this.placement = placement;
        this.advertiserName = advertiserName;
        this.headline = headline;
        this.bodyText = bodyText;
        this.offerText = offerText;
        this.price = price;
        this.cta = cta;
        this.canvasImageUrl = canvasImageUrl;
        this.logoImageUrl = logoImageUrl;
        this.clickthroughUrl = clickthroughUrl;
        this.impressionTrackingUrls = impressionTrackingUrls;
        this.clickTrackingUrls = clickTrackingUrls;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getOfferText() {
        return offerText;
    }

    public void setOfferText(String offerText) {
        this.offerText = offerText;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public String getCanvasImageUrl() {
        return canvasImageUrl;
    }

    public void setCanvasImageUrl(String canvasImageUrl) {
        this.canvasImageUrl = canvasImageUrl;
    }

    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl;
    }

    public String getClickthroughUrl() {
        return clickthroughUrl;
    }

    public void setClickthroughUrl(String clickthroughUrl) {
        this.clickthroughUrl = clickthroughUrl;
    }

    public List<String> getImpressionTrackingUrls() {
        return impressionTrackingUrls;
    }

    public void setImpressionTrackingUrls(List<String> impressionTrackingUrls) {
        this.impressionTrackingUrls = impressionTrackingUrls;
    }

    public List<String> getClickTrackingUrls() {
        return clickTrackingUrls;
    }

    public void setClickTrackingUrls(List<String> clickTrackingUrls) {
        this.clickTrackingUrls = clickTrackingUrls;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "AdCreative{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", placement='" + placement + '\'' +
                ", advertiserName='" + advertiserName + '\'' +
                ", headline='" + headline + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", offerText='" + offerText + '\'' +
                ", price='" + price + '\'' +
                ", cta='" + cta + '\'' +
                ", canvasImageUrl='" + canvasImageUrl + '\'' +
                ", logoImageUrl='" + logoImageUrl + '\'' +
                ", clickthroughUrl='" + clickthroughUrl + '\'' +
                ", impressionTrackingUrls=" + impressionTrackingUrls +
                ", clickTrackingUrls=" + clickTrackingUrls +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public static AdCreative findById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIFindAdCreativeById(nextDoorAPIAuth, id).execute();
    }

    public static NextDoorAPIFindAdCreativeStatsById findAdCreativeStatsById(String id, NextDoorAPIAuth nextDoorAPIAuth) {
        return new NextDoorAPIFindAdCreativeStatsById(nextDoorAPIAuth, id);
    }

    static class NextDoorAPIFindAdCreativeById extends NextDoorAPIRequest<AdCreative> implements NextDoorAPIExecute<AdCreative> {
        private final String id;

        public NextDoorAPIFindAdCreativeById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(AdCreative.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "creative/get/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdCreative execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AdCreativeNotFoundException("Cannot find Ad group with id: " + this.id + " because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdCreativeNotFoundException extends APIRequestException {
            public AdCreativeNotFoundException() {
            }

            public AdCreativeNotFoundException(String s) {
                super(s);
            }

            public AdCreativeNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdCreativeNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdCreativeNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIFindAdCreativeStatsById extends NextDoorAPIRequest<AdCreativeStatsById> implements NextDoorAPIExecute<AdCreativeStatsById> {
        private final String id;

        public NextDoorAPIFindAdCreativeStatsById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(AdCreativeStatsById.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        public NextDoorAPIFindAdCreativeStatsById setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIFindAdCreativeStatsById setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIFindAdCreativeStatsById setStartTime(Date startTime) {
            return setStartTime(NextDoorUtil.formatDate(startTime));
        }

        public NextDoorAPIFindAdCreativeStatsById setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        public NextDoorAPIFindAdCreativeStatsById setEndTime(Date endTime) {
            return setEndTime(NextDoorUtil.formatDate(endTime));
        }

        @Override
        protected String getPath() {
            return "creative/get/" + this.id + "/stats";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdCreativeStatsById execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdCreativeStatsByIdFoundException("Can't find Ad creative stats by ID " + this.id + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdCreativeStatsByIdFoundException extends APIRequestException {
            public AdCreativeStatsByIdFoundException() {
            }

            public AdCreativeStatsByIdFoundException(String s) {
                super(s);
            }

            public AdCreativeStatsByIdFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdCreativeStatsByIdFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdCreativeStatsByIdFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }


}