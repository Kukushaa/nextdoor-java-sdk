package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgeTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("age_targeting")
    private List<Age> ageTargeting;

    public AgeTargeting() {

    }

    public AgeTargeting(List<Age> ageTargeting) {
        this.ageTargeting = ageTargeting;
    }

    public List<Age> getAgeTargeting() {
        return ageTargeting;
    }

    public void setAgeTargeting(List<Age> ageTargeting) {
        this.ageTargeting = ageTargeting;
    }

    @Override
    public String toString() {
        return "AgeTargeting{" +
                "ageTargeting=" + ageTargeting +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Age implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public Age() {

        }

        public Age(String id, String name) {
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
            return "Age{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}