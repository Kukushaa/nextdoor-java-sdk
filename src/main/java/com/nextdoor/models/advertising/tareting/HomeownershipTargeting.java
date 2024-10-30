package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeownershipTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("homeownership_targeting")
    private List<Homeownership> homeownershipTargeting;

    public HomeownershipTargeting() {

    }

    public HomeownershipTargeting(List<Homeownership> homeownershipTargeting) {
        this.homeownershipTargeting = homeownershipTargeting;
    }

    public List<Homeownership> getHomeownershipTargeting() {
        return homeownershipTargeting;
    }

    public void setHomeownershipTargeting(List<Homeownership> homeownershipTargeting) {
        this.homeownershipTargeting = homeownershipTargeting;
    }

    @Override
    public String toString() {
        return "HomeownershipTargeting{" +
                "homeownershipTargeting=" + homeownershipTargeting +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Homeownership implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public Homeownership() {

        }

        public Homeownership(String id, String name) {
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

        @Override
        public String toString() {
            return "Homeownership{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}