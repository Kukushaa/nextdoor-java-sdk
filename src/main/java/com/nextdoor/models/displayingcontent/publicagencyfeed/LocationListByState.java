/*
 * Copyright (c) 2024 Nika Beridze
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.nextdoor.models.displayingcontent.publicagencyfeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationListByState extends NextDoorModel implements Serializable {
    @JsonProperty("category")
    private int category;

    @JsonProperty("centroid")
    private Object centroid;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("display_email")
    private String displayEmail;

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("post_count")
    private int postCount;

    @JsonProperty("public_url")
    private String publicUrl;

    @JsonProperty("state")
    private String state;

    public LocationListByState() {

    }

    public LocationListByState(int category, Object centroid, String city, String country, String displayEmail, int id, String name, String phoneNumber, int postCount, String publicUrl, String state) {
        this.category = category;
        this.centroid = centroid;
        this.city = city;
        this.country = country;
        this.displayEmail = displayEmail;
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.postCount = postCount;
        this.publicUrl = publicUrl;
        this.state = state;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Object getCentroid() {
        return centroid;
    }

    public void setCentroid(Object centroid) {
        this.centroid = centroid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDisplayEmail() {
        return displayEmail;
    }

    public void setDisplayEmail(String displayEmail) {
        this.displayEmail = displayEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LocationListByState{" +
                "category=" + category +
                ", centroid=" + centroid +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", displayEmail='" + displayEmail + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", postCount=" + postCount +
                ", publicUrl='" + publicUrl + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
