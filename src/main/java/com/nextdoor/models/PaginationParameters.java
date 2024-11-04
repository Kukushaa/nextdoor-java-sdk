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
