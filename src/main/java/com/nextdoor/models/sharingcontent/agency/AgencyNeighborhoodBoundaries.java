package com.nextdoor.models.sharingcontent.agency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyNeighborhoodBoundaries extends NextDoorModel implements Serializable {
    @JsonProperty("has_next_page")
    private boolean hasNextPage;

    @JsonProperty("cursor")
    private String cursor;

    @JsonProperty("result")
    private List<AgencyBoundaries> result;

    public AgencyNeighborhoodBoundaries() {

    }

    public AgencyNeighborhoodBoundaries(boolean hasNextPage, String cursor, List<AgencyBoundaries> result) {
        this.hasNextPage = hasNextPage;
        this.cursor = cursor;
        this.result = result;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<AgencyBoundaries> getResult() {
        return result;
    }

    public void setResult(List<AgencyBoundaries> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AgencyNeighborhoodBoundaries{" +
                "hasNextPage=" + hasNextPage +
                ", cursor='" + cursor + '\'' +
                ", result=" + result +
                '}';
    }
}
