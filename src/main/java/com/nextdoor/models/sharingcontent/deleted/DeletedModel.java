package com.nextdoor.models.sharingcontent.deleted;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeletedModel extends NextDoorModel implements Serializable {
    @JsonProperty("message")
    private String message;

    public DeletedModel() {

    }

    public DeletedModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DeletedModel{" +
                "message='" + message + '\'' +
                '}';
    }
}
