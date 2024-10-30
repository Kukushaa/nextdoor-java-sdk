package com.nextdoor.models.displayingcontent.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchEvents extends NextDoorModel implements Serializable {
    @JsonProperty("available")
    private boolean available;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lon")
    private double lon;

    @JsonProperty("startTime")
    private long startTime;

    @JsonProperty("endTime")
    private Long endTime;

    @JsonProperty("id")
    private String id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("coverPhoto")
    private String coverPhoto;

    public SearchEvents() {

    }

    public SearchEvents(boolean available, double lat, double lon, long startTime, Long endTime, String id, String description, String title, String url, String coverPhoto) {
        this.available = available;
        this.lat = lat;
        this.lon = lon;
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.description = description;
        this.title = title;
        this.url = url;
        this.coverPhoto = coverPhoto;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    @Override
    public String toString() {
        return "SearchEvents{" +
                "available=" + available +
                ", lat=" + lat +
                ", lon=" + lon +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                '}';
    }
}
