package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DMATargeting extends NextDoorModel implements Serializable {
    @JsonProperty("dma_targeting")
    private List<DMA> dmaTargeting;

    public DMATargeting() {

    }

    public DMATargeting(List<DMA> dmaTargeting) {
        this.dmaTargeting = dmaTargeting;
    }

    public List<DMA> getDmaTargeting() {
        return dmaTargeting;
    }

    public void setDmaTargeting(List<DMA> dmaTargeting) {
        this.dmaTargeting = dmaTargeting;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DMA implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public DMA() {

        }

        public DMA(String id, String name) {
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