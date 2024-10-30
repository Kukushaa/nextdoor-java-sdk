package com.nextdoor.models.advertising.advertiser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.advertising.campaign.Campaign;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertiserCampaigns extends NextDoorModel implements Serializable {
    @JsonProperty("campaigns")
    private List<CampaignsData> campaignsData;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdvertiserCampaigns() {

    }

    public AdvertiserCampaigns(List<CampaignsData> campaignsData, Pagination pageInfo) {
        this.campaignsData = campaignsData;
        this.pageInfo = pageInfo;
    }

    public List<CampaignsData> getCampaigns() {
        return campaignsData;
    }

    public void setCampaigns(List<CampaignsData> campaignsData) {
        this.campaignsData = campaignsData;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CampaignsData implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private Campaign data;

        public CampaignsData() {

        }

        public CampaignsData(String cursor, Campaign data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public Campaign getData() {
            return data;
        }

        public void setData(Campaign data) {
            this.data = data;
        }
    }
}