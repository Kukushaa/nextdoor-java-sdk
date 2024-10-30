package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginationParameters implements Serializable {
    @JsonProperty("page_size")
    private int pageSize;

    @JsonProperty("cursor")
    private String cursor;

    public PaginationParameters() {

    }

    public PaginationParameters(int pageSize, String cursor) {
        this.pageSize = pageSize;
        this.cursor = cursor;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public PaginationParametersBuilder builder() {
        return new PaginationParametersBuilder();
    }

    public static class PaginationParametersBuilder {
        private final PaginationParameters paginationParameters;

        public PaginationParametersBuilder() {
            this.paginationParameters = new PaginationParameters();
        }

        public PaginationParametersBuilder pageSize(int pageSize) {
            this.paginationParameters.pageSize = pageSize;

            return this;
        }

        public PaginationParametersBuilder cursor(String cursor) {
            this.paginationParameters.cursor = cursor;

            return this;
        }

        public PaginationParameters build() {
            return this.paginationParameters;
        }
    }
}