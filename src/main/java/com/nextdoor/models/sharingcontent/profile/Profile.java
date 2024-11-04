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
package com.nextdoor.models.sharingcontent.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

public class Profile extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("profile_picture")
    private String profilePicture;

    @JsonProperty("status")
    private String status;

    @JsonProperty("account_creation_date")
    private String accountCreationDate;

    @JsonProperty("verified")
    private String verified;

    @JsonProperty("is_agency_profile")
    private String isAgencyProfile;

    @JsonProperty("is_business_profile")
    private String isBusinessProfile;

    @JsonProperty("is_neighbor_profile")
    private String isNeighborProfile;

    @JsonProperty("neighborhood_name")
    private String neighborhoodName;

    @JsonProperty("neighborhood_url")
    private String neighborhoodUrl;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("business_name")
    private String businessName;

    @JsonProperty("agency_id")
    private String agencyId;

    @JsonProperty("agency_name")
    private String agencyName;

    @JsonProperty("agency_url_at_nextdoor")
    private String agencyUrlAtNextdoor;

    @JsonProperty("agency_external_url")
    private String agencyExternalUrl;

    @JsonProperty("agency_photo")
    private String agencyPhoto;

    @JsonProperty("agency_city")
    private String agencyCity;

    @JsonProperty("agency_state")
    private String agencyState;

    public Profile() {

    }

    public Profile(String id, String firstName, String lastName, String profilePicture, String status, String accountCreationDate, String verified, String isAgencyProfile, String isBusinessProfile, String isNeighborProfile, String neighborhoodName, String neighborhoodUrl, String cityName, String businessName, String agencyId, String agencyName, String agencyUrlAtNextdoor, String agencyExternalUrl, String agencyPhoto, String agencyCity, String agencyState) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.status = status;
        this.accountCreationDate = accountCreationDate;
        this.verified = verified;
        this.isAgencyProfile = isAgencyProfile;
        this.isBusinessProfile = isBusinessProfile;
        this.isNeighborProfile = isNeighborProfile;
        this.neighborhoodName = neighborhoodName;
        this.neighborhoodUrl = neighborhoodUrl;
        this.cityName = cityName;
        this.businessName = businessName;
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.agencyUrlAtNextdoor = agencyUrlAtNextdoor;
        this.agencyExternalUrl = agencyExternalUrl;
        this.agencyPhoto = agencyPhoto;
        this.agencyCity = agencyCity;
        this.agencyState = agencyState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(String accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getIsAgencyProfile() {
        return isAgencyProfile;
    }

    public void setIsAgencyProfile(String isAgencyProfile) {
        this.isAgencyProfile = isAgencyProfile;
    }

    public String getIsBusinessProfile() {
        return isBusinessProfile;
    }

    public void setIsBusinessProfile(String isBusinessProfile) {
        this.isBusinessProfile = isBusinessProfile;
    }

    public String getIsNeighborProfile() {
        return isNeighborProfile;
    }

    public void setIsNeighborProfile(String isNeighborProfile) {
        this.isNeighborProfile = isNeighborProfile;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyUrlAtNextdoor() {
        return agencyUrlAtNextdoor;
    }

    public void setAgencyUrlAtNextdoor(String agencyUrlAtNextdoor) {
        this.agencyUrlAtNextdoor = agencyUrlAtNextdoor;
    }

    public String getAgencyExternalUrl() {
        return agencyExternalUrl;
    }

    public void setAgencyExternalUrl(String agencyExternalUrl) {
        this.agencyExternalUrl = agencyExternalUrl;
    }

    public String getAgencyPhoto() {
        return agencyPhoto;
    }

    public void setAgencyPhoto(String agencyPhoto) {
        this.agencyPhoto = agencyPhoto;
    }

    public String getAgencyCity() {
        return agencyCity;
    }

    public void setAgencyCity(String agencyCity) {
        this.agencyCity = agencyCity;
    }

    public String getAgencyState() {
        return agencyState;
    }

    public void setAgencyState(String agencyState) {
        this.agencyState = agencyState;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", status='" + status + '\'' +
                ", accountCreationDate='" + accountCreationDate + '\'' +
                ", verified='" + verified + '\'' +
                ", isAgencyProfile='" + isAgencyProfile + '\'' +
                ", isBusinessProfile='" + isBusinessProfile + '\'' +
                ", isNeighborProfile='" + isNeighborProfile + '\'' +
                ", neighborhoodName='" + neighborhoodName + '\'' +
                ", neighborhoodUrl='" + neighborhoodUrl + '\'' +
                ", cityName='" + cityName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", agencyId='" + agencyId + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", agencyUrlAtNextdoor='" + agencyUrlAtNextdoor + '\'' +
                ", agencyExternalUrl='" + agencyExternalUrl + '\'' +
                ", agencyPhoto='" + agencyPhoto + '\'' +
                ", agencyCity='" + agencyCity + '\'' +
                ", agencyState='" + agencyState + '\'' +
                '}';
    }
}
