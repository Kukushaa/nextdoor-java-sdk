package com.nextdoor.models.sharingcontent.agency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyBoundaries extends NextDoorModel implements Serializable {
    @JsonProperty("name")
    private String name;

    @JsonProperty("group_id")
    private int groupId;

    @JsonProperty("geometry_id")
    private int geometryId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("geometry")
    private String geometry;

    public AgencyBoundaries() {
    }

    public AgencyBoundaries(String name, int groupId, int geometryId, String type, String geometry) {
        this.name = name;
        this.groupId = groupId;
        this.geometryId = geometryId;
        this.type = type;
        this.geometry = geometry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGeometryId() {
        return geometryId;
    }

    public void setGeometryId(int geometryId) {
        this.geometryId = geometryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "CustomBoundary{" +
                "name='" + name + '\'' +
                ", groupId=" + groupId +
                ", geometryId=" + geometryId +
                ", type='" + type + '\'' +
                ", geometry='" + geometry + '\'' +
                '}';
    }
}
