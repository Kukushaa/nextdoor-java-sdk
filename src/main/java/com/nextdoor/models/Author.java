package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.displayingcontent.publicagencyfeed.AgencyPosts;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author implements Serializable {
    @JsonProperty("agencyInfo")
    private AgencyInfo agencyInfo;

    @JsonProperty("cityUrl")
    private String cityUrl;

    @JsonProperty("name")
    private String name;

    @JsonProperty("neighborhoodName")
    private String neighborhoodName;

    @JsonProperty("neighborhoodUrl")
    private String neighborhoodUrl;

    @JsonProperty("type")
    private String type;

    public Author() {

    }

    public Author(AgencyInfo agencyInfo, String cityUrl, String name, String neighborhoodName, String neighborhoodUrl, String type) {
        this.agencyInfo = agencyInfo;
        this.cityUrl = cityUrl;
        this.name = name;
        this.neighborhoodName = neighborhoodName;
        this.neighborhoodUrl = neighborhoodUrl;
        this.type = type;
    }

    public AgencyInfo getAgencyInfo() {
        return agencyInfo;
    }

    public void setAgencyInfo(AgencyInfo agencyInfo) {
        this.agencyInfo = agencyInfo;
    }

    public String getCityUrl() {
        return cityUrl;
    }

    public void setCityUrl(String cityUrl) {
        this.cityUrl = cityUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public String getNeighborhoodUrl() {
        return neighborhoodUrl;
    }

    public void setNeighborhoodUrl(String neighborhoodUrl) {
        this.neighborhoodUrl = neighborhoodUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Author{" +
                "agencyInfo=" + agencyInfo +
                ", cityUrl='" + cityUrl + '\'' +
                ", name='" + name + '\'' +
                ", neighborhoodName='" + neighborhoodName + '\'' +
                ", neighborhoodUrl='" + neighborhoodUrl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AgencyInfo implements Serializable {
        @JsonProperty("address")
        private String address;

        @JsonProperty("city")
        private String city;

        @JsonProperty("name")
        private String name;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("post_to_areas")
        private List<AgencyPosts.PostArea> postToAreas;

        public AgencyInfo() {

        }

        public AgencyInfo(String address, String city, String name, String phone, List<AgencyPosts.PostArea> postToAreas) {
            this.address = address;
            this.city = city;
            this.name = name;
            this.phone = phone;
            this.postToAreas = postToAreas;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public List<AgencyPosts.PostArea> getPostToAreas() {
            return postToAreas;
        }

        public void setPostToAreas(List<AgencyPosts.PostArea> postToAreas) {
            this.postToAreas = postToAreas;
        }

        @Override
        public String toString() {
            return "AgencyInfo{" +
                    "address='" + address + '\'' +
                    ", city='" + city + '\'' +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", postToAreas=" + postToAreas +
                    '}';
        }
    }
}