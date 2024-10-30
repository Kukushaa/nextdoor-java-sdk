package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenderTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("gender_targeting")
    private List<Gender> genderTargeting;

    public GenderTargeting() {

    }

    public GenderTargeting(List<Gender> genderTargeting) {
        this.genderTargeting = genderTargeting;
    }

    public List<Gender> getGenderTargeting() {
        return genderTargeting;
    }

    public void setGenderTargeting(List<Gender> genderTargeting) {
        this.genderTargeting = genderTargeting;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Gender implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public Gender() {

        }

        public Gender(String id, String name) {
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