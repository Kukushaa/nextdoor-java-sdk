package com.nextdoor.models.displayingcontent.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchFSFItems extends NextDoorModel implements Serializable {
    @JsonProperty("available")
    private boolean available;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lon")
    private double lon;

    @JsonProperty("price")
    private int price;

    @JsonProperty("expirationDate")
    private long expirationDate;

    @JsonProperty("id")
    private String id;

    @JsonProperty("city")
    private String city;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("description")
    private String description;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("photos")
    private List<String> photos;

    public SearchFSFItems() {

    }

    public SearchFSFItems(boolean available, double lat, double lon, int price, long expirationDate, String id, String city, String currency, String description, String title, String url, List<String> photos) {
        this.available = available;
        this.lat = lat;
        this.lon = lon;
        this.price = price;
        this.expirationDate = expirationDate;
        this.id = id;
        this.city = city;
        this.currency = currency;
        this.description = description;
        this.title = title;
        this.url = url;
        this.photos = photos;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "SearchFSFItems{" +
                "available=" + available +
                ", lat=" + lat +
                ", lon=" + lon +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                ", id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", photos=" + photos +
                '}';
    }
}
