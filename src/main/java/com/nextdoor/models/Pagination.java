package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination implements Serializable {
    @JsonProperty("end_cursor")
    private String endCursor;

    @JsonProperty("page_size")
    private int pageSize;

    public Pagination() {

    }

    public Pagination(String endCursor, int pageSize) {
        this.endCursor = endCursor;
        this.pageSize = pageSize;
    }

    public String getEndCursor() {
        return endCursor;
    }

    public void setEndCursor(String endCursor) {
        this.endCursor = endCursor;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "endCursor='" + endCursor + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }
}