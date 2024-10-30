package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StateTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("state_targeting")
    private List<State> stateTargeting;

    public StateTargeting() {

    }

    public StateTargeting(List<State> stateTargeting) {
        this.stateTargeting = stateTargeting;
    }

    public List<State> getStateTargeting() {
        return stateTargeting;
    }

    public void setStateTargeting(List<State> stateTargeting) {
        this.stateTargeting = stateTargeting;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class State implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public State() {

        }

        public State(String id, String name) {
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