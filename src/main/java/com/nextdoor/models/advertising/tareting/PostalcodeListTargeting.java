package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalcodeListTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("postalcode_targeting")
    private List<PostalCodeTargeting> postalCodeTargeting;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public PostalcodeListTargeting() {
    }

    public PostalcodeListTargeting(List<PostalCodeTargeting> postalCodeTargeting, Pagination pageInfo) {
        this.postalCodeTargeting = postalCodeTargeting;
        this.pageInfo = pageInfo;
    }

    public List<PostalCodeTargeting> getPostalCodeTargeting() {
        return postalCodeTargeting;
    }

    public void setPostalCodeTargeting(List<PostalCodeTargeting> postalCodeTargeting) {
        this.postalCodeTargeting = postalCodeTargeting;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PostalCodeTargeting implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private PostalCodeData data;

        public PostalCodeTargeting() {
        }

        public PostalCodeTargeting(String cursor, PostalCodeData data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public PostalCodeData getData() {
            return data;
        }

        public void setData(PostalCodeData data) {
            this.data = data;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PostalCodeData implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public PostalCodeData() {
        }

        public PostalCodeData(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
