package com.nextdoor.models.advertising.advertiser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.advertising.creative.AdCreative;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertiserCreatives extends NextDoorModel implements Serializable {
    @JsonProperty("creatives")
    private List<CreativeData> creativeData;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdvertiserCreatives() {

    }

    public AdvertiserCreatives(List<CreativeData> creativeData, Pagination pageInfo) {
        this.creativeData = creativeData;
        this.pageInfo = pageInfo;
    }

    public List<CreativeData> getCreatives() {
        return creativeData;
    }

    public void setCreatives(List<CreativeData> creativeData) {
        this.creativeData = creativeData;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreativeData implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private AdCreative data;

        public CreativeData() {

        }

        public CreativeData(String cursor, AdCreative data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public AdCreative getData() {
            return data;
        }

        public void setData(AdCreative data) {
            this.data = data;
        }
    }
}
