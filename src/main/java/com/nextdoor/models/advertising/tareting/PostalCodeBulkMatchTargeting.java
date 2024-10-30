package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalCodeBulkMatchTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("matching_postal_code_ids")
    private List<String> matchingPostalCodeIds;

    @JsonProperty("invalid_postal_codes")
    private List<String> invalidPostalCodes;

    public PostalCodeBulkMatchTargeting() {
    }

    public PostalCodeBulkMatchTargeting(List<String> matchingPostalCodeIds, List<String> invalidPostalCodes) {
        this.matchingPostalCodeIds = matchingPostalCodeIds;
        this.invalidPostalCodes = invalidPostalCodes;
    }

    public List<String> getMatchingPostalCodeIds() {
        return matchingPostalCodeIds;
    }

    public void setMatchingPostalCodeIds(List<String> matchingPostalCodeIds) {
        this.matchingPostalCodeIds = matchingPostalCodeIds;
    }

    public List<String> getInvalidPostalCodes() {
        return invalidPostalCodes;
    }

    public void setInvalidPostalCodes(List<String> invalidPostalCodes) {
        this.invalidPostalCodes = invalidPostalCodes;
    }
}
