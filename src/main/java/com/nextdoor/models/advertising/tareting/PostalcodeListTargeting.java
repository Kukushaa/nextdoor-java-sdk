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
package com.nextdoor.models.advertising.tareting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalcodeListTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("postalcode_targeting")
    private List<PostalCodeTargeting> postalCodeTargeting;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public PostalcodeListTargeting() {
    }

    public PostalcodeListTargeting(List<PostalCodeTargeting> postalCodeTargeting, Pagination pageInfo) {
        this.postalCodeTargeting = postalCodeTargeting;
        this.pageInfo = pageInfo;
    }

    public List<PostalCodeTargeting> getPostalCodeTargeting() {
        return postalCodeTargeting;
    }

    public void setPostalCodeTargeting(List<PostalCodeTargeting> postalCodeTargeting) {
        this.postalCodeTargeting = postalCodeTargeting;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PostalCodeTargeting implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private PostalCodeData data;

        public PostalCodeTargeting() {
        }

        public PostalCodeTargeting(String cursor, PostalCodeData data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public PostalCodeData getData() {
            return data;
        }

        public void setData(PostalCodeData data) {
            this.data = data;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PostalCodeData implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        public PostalCodeData() {
        }

        public PostalCodeData(String id, String name) {
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
