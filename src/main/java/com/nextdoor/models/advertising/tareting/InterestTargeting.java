package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InterestTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("interest_targeting")
    private List<Interest> interestTargeting;

    public InterestTargeting() {
    }

    public InterestTargeting(List<Interest> interestTargeting) {
        this.interestTargeting = interestTargeting;
    }

    public List<Interest> getInterestTargeting() {
        return interestTargeting;
    }

    public void setInterestTargeting(List<Interest> interestTargeting) {
        this.interestTargeting = interestTargeting;
    }

    @Override
    public String toString() {
        return "InterestTargeting{" +
                "interestTargeting=" + interestTargeting +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Interest implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public Interest() {
        }

        public Interest(String id, String name) {
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
            return "Interest{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
