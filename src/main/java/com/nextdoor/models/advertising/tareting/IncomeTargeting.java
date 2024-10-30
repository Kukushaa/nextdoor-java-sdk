package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomeTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("income_targeting")
    private List<Income> incomeTargeting;

    public IncomeTargeting() {
    }

    public IncomeTargeting(List<Income> incomeTargeting) {
        this.incomeTargeting = incomeTargeting;
    }

    public List<Income> getIncomeTargeting() {
        return incomeTargeting;
    }

    public void setIncomeTargeting(List<Income> incomeTargeting) {
        this.incomeTargeting = incomeTargeting;
    }

    @Override
    public String toString() {
        return "IncomeTargeting{" +
                "incomeTargeting=" + incomeTargeting +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Income implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public Income() {
        }

        public Income(String id, String name) {
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
            return "Income{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}