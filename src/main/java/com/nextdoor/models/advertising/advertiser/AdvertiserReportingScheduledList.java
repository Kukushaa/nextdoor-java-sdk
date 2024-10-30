package com.nextdoor.models.advertising.advertiser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;
import com.nextdoor.models.advertising.reporting.AdScheduledReport;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertiserReportingScheduledList extends NextDoorModel implements Serializable {
    @JsonProperty("scheduled_reports")
    private List<ScheduledReportData> scheduledReportData;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdvertiserReportingScheduledList() {
    }

    public AdvertiserReportingScheduledList(List<ScheduledReportData> scheduledReportData, Pagination pageInfo) {
        this.scheduledReportData = scheduledReportData;
        this.pageInfo = pageInfo;
    }

    public List<ScheduledReportData> getScheduledReports() {
        return scheduledReportData;
    }

    public void setScheduledReports(List<ScheduledReportData> scheduledReportData) {
        this.scheduledReportData = scheduledReportData;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ScheduledReportData implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private AdScheduledReport data;

        public ScheduledReportData() {
        }

        public ScheduledReportData(String cursor, AdScheduledReport data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public AdScheduledReport getData() {
            return data;
        }

        public void setData(AdScheduledReport data) {
            this.data = data;
        }
    }
}