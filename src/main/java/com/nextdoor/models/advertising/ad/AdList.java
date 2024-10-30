package com.nextdoor.models.advertising.ad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdList extends NextDoorModel implements Serializable {
    @JsonProperty("ads")
    private List<AdData> ads;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdList() {

    }

    public AdList(List<AdData> ads, Pagination pageInfo) {
        this.ads = ads;
        this.pageInfo = pageInfo;
    }

    public List<AdData> getAds() {
        return ads;
    }

    public void setAds(List<AdData> ads) {
        this.ads = ads;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AdData implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private Ad data;

        public AdData() {
        }

        public AdData(String cursor, Ad data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public Ad getData() {
            return data;
        }

        public void setData(Ad data) {
            this.data = data;
        }
    }
}