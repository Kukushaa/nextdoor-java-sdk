package com.nextdoor.models.advertising.agroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdGroupList extends NextDoorModel implements Serializable {
    @JsonProperty("adgroups")
    private List<AdGroupData> adGroupData;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdGroupList() {
    }

    public AdGroupList(List<AdGroupData> adGroupData, Pagination pageInfo) {
        this.adGroupData = adGroupData;
        this.pageInfo = pageInfo;
    }

    public List<AdGroupData> getAdGroups() {
        return adGroupData;
    }

    public void setAdGroups(List<AdGroupData> adGroupData) {
        this.adGroupData = adGroupData;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AdGroupData implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private AdGroup data;

        public AdGroupData() {

        }

        public AdGroupData(String cursor, AdGroup data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public AdGroup getData() {
            return data;
        }

        public void setData(AdGroup data) {
            this.data = data;
        }
    }
}