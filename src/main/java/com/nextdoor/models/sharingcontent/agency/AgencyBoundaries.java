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
