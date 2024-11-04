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
package com.nextdoor.models.advertising.advertiser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.advertising.campaign.Campaign;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertiserCampaigns extends NextDoorModel implements Serializable {
    @JsonProperty("campaigns")
    private List<CampaignsData> campaignsData;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdvertiserCampaigns() {

    }

    public AdvertiserCampaigns(List<CampaignsData> campaignsData, Pagination pageInfo) {
        this.campaignsData = campaignsData;
        this.pageInfo = pageInfo;
    }

    public List<CampaignsData> getCampaigns() {
        return campaignsData;
    }

    public void setCampaigns(List<CampaignsData> campaignsData) {
        this.campaignsData = campaignsData;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CampaignsData implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private Campaign data;

        public CampaignsData() {

        }

        public CampaignsData(String cursor, Campaign data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public Campaign getData() {
            return data;
        }

        public void setData(Campaign data) {
            this.data = data;
        }
    }
}
