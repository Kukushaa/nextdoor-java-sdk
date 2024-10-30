package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("device_targeting")
    private List<Device> deviceTargeting;

    public DeviceTargeting() {
    }

    public DeviceTargeting(List<Device> deviceTargeting) {
        this.deviceTargeting = deviceTargeting;
    }

    public List<Device> getDeviceTargeting() {
        return deviceTargeting;
    }

    public void setDeviceTargeting(List<Device> deviceTargeting) {
        this.deviceTargeting = deviceTargeting;
    }

    @Override
    public String toString() {
        return "DeviceTargeting{" +
                "deviceTargeting=" + deviceTargeting +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Device implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public Device() {
        }

        public Device(String id, String name) {
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
            return "Device{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
