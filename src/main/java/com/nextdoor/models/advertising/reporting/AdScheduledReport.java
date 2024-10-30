package com.nextdoor.models.advertising.reporting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdScheduledReport extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("schedule")
    private Schedule schedule;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("recipient_emails")
    private List<String> recipientEmails;

    @JsonProperty("dimension_granularity")
    private List<DimesionGranularity> dimensionGranularity;

    @JsonProperty("time_granularity")
    private List<TimeGranularity> timeGranularity;

    @JsonProperty("metrics")
    private List<Metrics> metrics;

    @JsonProperty("campaign_ids")
    private List<String> campaignIds;

    @JsonProperty("adgroup_ids")
    private List<String> adGroupIds;

    @JsonProperty("ad_ids")
    private List<String> adIds;

    @JsonProperty("is_archived")
    private boolean isArchived;

    public AdScheduledReport() {

    }

    public AdScheduledReport(String id, String advertiserId, String name, Schedule schedule, String timezone,
                             List<String> recipientEmails, List<DimesionGranularity> dimensionGranularity,
                             List<TimeGranularity> timeGranularity, List<Metrics> metrics, List<String> campaignIds,
                             List<String> adGroupIds, List<String> adIds, boolean isArchived) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.name = name;
        this.schedule = schedule;
        this.timezone = timezone;
        this.recipientEmails = recipientEmails;
        this.dimensionGranularity = dimensionGranularity;
        this.timeGranularity = timeGranularity;
        this.metrics = metrics;
        this.campaignIds = campaignIds;
        this.adGroupIds = adGroupIds;
        this.adIds = adIds;
        this.isArchived = isArchived;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<String> getRecipientEmails() {
        return recipientEmails;
    }

    public void setRecipientEmails(List<String> recipientEmails) {
        this.recipientEmails = recipientEmails;
    }

    public List<DimesionGranularity> getDimensionGranularity() {
        return dimensionGranularity;
    }

    public void setDimensionGranularity(List<DimesionGranularity> dimensionGranularity) {
        this.dimensionGranularity = dimensionGranularity;
    }

    public List<TimeGranularity> getTimeGranularity() {
        return timeGranularity;
    }

    public void setTimeGranularity(List<TimeGranularity> timeGranularity) {
        this.timeGranularity = timeGranularity;
    }

    public List<Metrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metrics> metrics) {
        this.metrics = metrics;
    }

    public List<String> getCampaignIds() {
        return campaignIds;
    }

    public void setCampaignIds(List<String> campaignIds) {
        this.campaignIds = campaignIds;
    }

    public List<String> getAdGroupIds() {
        return adGroupIds;
    }

    public void setAdGroupIds(List<String> adGroupIds) {
        this.adGroupIds = adGroupIds;
    }

    public List<String> getAdIds() {
        return adIds;
    }

    public void setAdIds(List<String> adIds) {
        this.adIds = adIds;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public enum DimesionGranularity {
        CAMPAIGN,
        AD_GROUP,
        AD,
        PLACEMENT
    }

    public enum TimeGranularity {
        DAY,
        WEEK,
        MONTH
    }

    public enum Schedule {
        DAILY,
        WEEKLY,
        MONTHLY,
        QUARTERLY
    }

    public enum Metrics {
        CLICKS,
        IMPRESSSIONS,
        CTR,
        CONVERSIONS,
        SPEND,
        CPM,
        CPC,
        BILLABLE_SPEND
    }
}
