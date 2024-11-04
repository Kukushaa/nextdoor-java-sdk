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
package com.nextdoor.models.advertising.agroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdGroupList extends NextDoorModel implements Serializable {
    @JsonProperty("adgroups")
    private List<AdGroupData> adGroupData;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdGroupList() {
    }

    public AdGroupList(List<AdGroupData> adGroupData, Pagination pageInfo) {
        this.adGroupData = adGroupData;
        this.pageInfo = pageInfo;
    }

    public List<AdGroupData> getAdGroups() {
        return adGroupData;
    }

    public void setAdGroups(List<AdGroupData> adGroupData) {
        this.adGroupData = adGroupData;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AdGroupData implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private AdGroup data;

        public AdGroupData() {

        }

        public AdGroupData(String cursor, AdGroup data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public AdGroup getData() {
            return data;
        }

        public void setData(AdGroup data) {
            this.data = data;
        }
    }
}
