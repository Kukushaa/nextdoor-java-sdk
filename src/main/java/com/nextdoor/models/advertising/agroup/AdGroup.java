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
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.models.Pagination;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdGroup extends NextDoorModel implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("campaign_id")
    private String campaignId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("user_status")
    private String userStatus;

    @JsonProperty("placements")
    private List<String> placements;

    @JsonProperty("bid")
    private Bid bid;

    @JsonProperty("budget")
    private Budget budget;

    @JsonProperty("start_time")
    private ZonedDateTime startTime;

    @JsonProperty("end_time")
    private ZonedDateTime endTime;

    @JsonProperty("frequency_caps")
    private List<FrequencyCap> frequencyCaps;

    @JsonProperty("targeting")
    private Targeting targeting;

    @JsonProperty("custom_audience_ids")
    private List<String> customAudienceIds;

    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonProperty("updated_at")
    private Instant updatedAt;

    public AdGroup() {

    }

    public AdGroup(String id, String advertiserId, String campaignId, String name, String status, String userStatus, List<String> placements, Bid bid, Budget budget, ZonedDateTime startTime, ZonedDateTime endTime, List<FrequencyCap> frequencyCaps, Targeting targeting, List<String> customAudienceIds, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.campaignId = campaignId;
        this.name = name;
        this.status = status;
        this.userStatus = userStatus;
        this.placements = placements;
        this.bid = bid;
        this.budget = budget;
        this.startTime = startTime;
        this.endTime = endTime;
        this.frequencyCaps = frequencyCaps;
        this.targeting = targeting;
        this.customAudienceIds = customAudienceIds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public List<String> getPlacements() {
        return placements;
    }

    public void setPlacements(List<String> placements) {
        this.placements = placements;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public List<FrequencyCap> getFrequencyCaps() {
        return frequencyCaps;
    }

    public void setFrequencyCaps(List<FrequencyCap> frequencyCaps) {
        this.frequencyCaps = frequencyCaps;
    }

    public Targeting getTargeting() {
        return targeting;
    }

    public void setTargeting(Targeting targeting) {
        this.targeting = targeting;
    }

    public List<String> getCustomAudienceIds() {
        return customAudienceIds;
    }

    public void setCustomAudienceIds(List<String> customAudienceIds) {
        this.customAudienceIds = customAudienceIds;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "AdGroup{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", placements=" + placements +
                ", bid=" + bid +
                ", budget=" + budget +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", frequencyCaps=" + frequencyCaps +
                ", targeting=" + targeting +
                ", customAudienceIds=" + customAudienceIds +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Bid implements Serializable {
        @JsonProperty("amount")
        private String amount;

        @JsonProperty("pricing_type")
        private String pricingType;

        public Bid() {

        }

        public Bid(String amount, String pricingType) {
            this.amount = amount;
            this.pricingType = pricingType;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPricingType() {
            return pricingType;
        }

        public void setPricingType(String pricingType) {
            this.pricingType = pricingType;
        }

        public BidBuilder builder() {
            return new BidBuilder();
        }

        @Override
        public String toString() {
            return "Bid{" +
                    "amount='" + amount + '\'' +
                    ", pricingType='" + pricingType + '\'' +
                    '}';
        }

        public static class BidBuilder {
            private final Bid bid;

            public BidBuilder() {
                this.bid = new Bid();
            }

            public BidBuilder amount(String amount) {
                this.bid.amount = amount;

                return this;
            }

            public BidBuilder pricingType(String pricingType) {
                this.bid.pricingType = pricingType;

                return this;
            }

            public Bid create() {
                return this.bid;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Budget implements Serializable {
        @JsonProperty("amount")
        private String amount;

        @JsonProperty("budget_type")
        private String budgetType;

        public Budget() {

        }

        public Budget(String amount, String budgetType) {
            this.amount = amount;
            this.budgetType = budgetType;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getBudgetType() {
            return budgetType;
        }

        public void setBudgetType(String budgetType) {
            this.budgetType = budgetType;
        }

        public BudgetBuilder builder() {
            return new BudgetBuilder();
        }

        @Override
        public String toString() {
            return "Budget{" +
                    "amount='" + amount + '\'' +
                    ", budgetType='" + budgetType + '\'' +
                    '}';
        }

        public static class BudgetBuilder {
            private final Budget budget;

            public BudgetBuilder() {
                this.budget = new Budget();
            }

            public BudgetBuilder amount(String amount) {
                this.budget.amount = amount;

                return this;
            }

            public BudgetBuilder budgetType(String budgetType) {
                this.budget.budgetType = budgetType;

                return this;
            }

            public Budget create() {
                return this.budget;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FrequencyCap implements Serializable {
        @JsonProperty("max_impressions")
        private int maxImpressions;

        @JsonProperty("num_timeunits")
        private int numTimeunits;

        @JsonProperty("timeunit")
        private TimeUnit timeunit;

        public FrequencyCap() {

        }

        public FrequencyCap(int maxImpressions, int numTimeunits, TimeUnit timeunit) {
            this.maxImpressions = maxImpressions;
            this.numTimeunits = numTimeunits;
            this.timeunit = timeunit;
        }

        public int getMaxImpressions() {
            return maxImpressions;
        }

        public void setMaxImpressions(int maxImpressions) {
            this.maxImpressions = maxImpressions;
        }

        public int getNumTimeunits() {
            return numTimeunits;
        }

        public void setNumTimeunits(int numTimeunits) {
            this.numTimeunits = numTimeunits;
        }

        public TimeUnit getTimeunit() {
            return timeunit;
        }

        public void setTimeunit(TimeUnit timeunit) {
            this.timeunit = timeunit;
        }

        public FrequencyCapBuilder builder() {
            return new FrequencyCapBuilder();
        }

        @Override
        public String toString() {
            return "FrequencyCap{" +
                    "maxImpressions=" + maxImpressions +
                    ", numTimeunits=" + numTimeunits +
                    ", timeunit='" + timeunit + '\'' +
                    '}';
        }

        public enum TimeUnit {
            MINUTE,
            MINUTES,
            HOUR,
            HOURS,
            DAY,
            DAYS,
            WEEK,
            WEEKS,
            MONTH,
            MONTHS
        }

        public static class FrequencyCapBuilder {
            private final FrequencyCap frequencyCap;

            public FrequencyCapBuilder() {
                this.frequencyCap = new FrequencyCap();
            }

            public FrequencyCapBuilder maxImpressions(int maxImpressions) {
                this.frequencyCap.maxImpressions = maxImpressions;

                return this;
            }

            public FrequencyCapBuilder numTimeunits(int numTimeunits) {
                this.frequencyCap.numTimeunits = numTimeunits;

                return this;
            }

            public FrequencyCapBuilder timeunit(TimeUnit timeunit) {
                this.frequencyCap.timeunit = timeunit;

                return this;
            }

            public FrequencyCap create() {
                return this.frequencyCap;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Targeting implements Serializable {
        @JsonProperty("included_location_targeting_ids")
        private List<String> includedLocationTargetingIds;

        @JsonProperty("excluded_location_targeting_ids")
        private List<String> excludedLocationTargetingIds;

        @JsonProperty("audience_targeting_ids")
        private List<String> audienceTargetingIds;

        @JsonProperty("time_of_day")
        private TimeOfDay timeOfDay;

        public Targeting() {

        }

        public Targeting(List<String> includedLocationTargetingIds, List<String> excludedLocationTargetingIds, List<String> audienceTargetingIds, TimeOfDay timeOfDay) {
            this.includedLocationTargetingIds = includedLocationTargetingIds;
            this.excludedLocationTargetingIds = excludedLocationTargetingIds;
            this.audienceTargetingIds = audienceTargetingIds;
            this.timeOfDay = timeOfDay;
        }

        public List<String> getIncludedLocationTargetingIds() {
            return includedLocationTargetingIds;
        }

        public void setIncludedLocationTargetingIds(List<String> includedLocationTargetingIds) {
            this.includedLocationTargetingIds = includedLocationTargetingIds;
        }

        public List<String> getExcludedLocationTargetingIds() {
            return excludedLocationTargetingIds;
        }

        public void setExcludedLocationTargetingIds(List<String> excludedLocationTargetingIds) {
            this.excludedLocationTargetingIds = excludedLocationTargetingIds;
        }

        public List<String> getAudienceTargetingIds() {
            return audienceTargetingIds;
        }

        public void setAudienceTargetingIds(List<String> audienceTargetingIds) {
            this.audienceTargetingIds = audienceTargetingIds;
        }

        public TimeOfDay getTimeOfDay() {
            return timeOfDay;
        }

        public void setTimeOfDay(TimeOfDay timeOfDay) {
            this.timeOfDay = timeOfDay;
        }

        public TargetingBuilder builder() {
            return new TargetingBuilder();
        }

        @Override
        public String toString() {
            return "Targeting{" +
                    "includedLocationTargetingIds=" + includedLocationTargetingIds +
                    ", excludedLocationTargetingIds=" + excludedLocationTargetingIds +
                    ", audienceTargetingIds=" + audienceTargetingIds +
                    ", timeOfDay=" + timeOfDay +
                    '}';
        }

        public static class TargetingBuilder {
            private final Targeting targeting;

            public TargetingBuilder() {
                this.targeting = new Targeting();
            }

            public TargetingBuilder includedLocationTargetingIds(List<String> includedLocationTargetingIds) {
                this.targeting.includedLocationTargetingIds = includedLocationTargetingIds;

                return this;
            }

            public TargetingBuilder excludedLocationTargetingIds(List<String> excludedLocationTargetingIds) {
                this.targeting.excludedLocationTargetingIds = excludedLocationTargetingIds;

                return this;
            }

            public TargetingBuilder audienceTargetingIds(List<String> audienceTargetingIds) {
                this.targeting.audienceTargetingIds = audienceTargetingIds;

                return this;
            }

            public TargetingBuilder timeOfDay(TimeOfDay timeOfDay) {
                this.targeting.timeOfDay = timeOfDay;

                return this;
            }

            public Targeting create() {
                return this.targeting;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class TimeOfDay implements Serializable {
            @JsonProperty("included")
            private List<TimeSlot> included;

            @JsonProperty("excluded")
            private List<TimeSlot> excluded;

            public TimeOfDay() {

            }

            public TimeOfDay(List<TimeSlot> included, List<TimeSlot> excluded) {
                this.included = included;
                this.excluded = excluded;
            }

            public List<TimeSlot> getIncluded() {
                return included;
            }

            public void setIncluded(List<TimeSlot> included) {
                this.included = included;
            }

            public List<TimeSlot> getExcluded() {
                return excluded;
            }

            public void setExcluded(List<TimeSlot> excluded) {
                this.excluded = excluded;
            }

            public TimeOfDayBuilder builder() {
                return new TimeOfDayBuilder();
            }

            @Override
            public String toString() {
                return "TimeOfDay{" +
                        "included=" + included +
                        ", excluded=" + excluded +
                        '}';
            }

            public static class TimeOfDayBuilder {
                private final TimeOfDay timeOfDay;

                public TimeOfDayBuilder() {
                    this.timeOfDay = new TimeOfDay();
                }

                public TimeOfDayBuilder setIncluded(List<TimeSlot> included) {
                    this.timeOfDay.included = included;

                    return this;
                }

                public TimeOfDayBuilder setExcluded(List<TimeSlot> excluded) {
                    this.timeOfDay.excluded = excluded;

                    return this;
                }

                public TimeOfDay create() {
                    return this.timeOfDay;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class TimeSlot implements Serializable {
                @JsonProperty("days")
                private List<String> days;

                @JsonProperty("time")
                private TimeRange time;

                public TimeSlot() {

                }

                public TimeSlot(List<String> days, TimeRange time) {
                    this.days = days;
                    this.time = time;
                }

                public List<String> getDays() {
                    return days;
                }

                public void setDays(List<String> days) {
                    this.days = days;
                }

                public TimeRange getTime() {
                    return time;
                }

                public void setTime(TimeRange time) {
                    this.time = time;
                }

                public TimeSlotBuilder builder() {
                    return new TimeSlotBuilder();
                }

                @Override
                public String toString() {
                    return "TimeSlot{" +
                            "days=" + days +
                            ", time=" + time +
                            '}';
                }

                public static class TimeSlotBuilder {
                    private final TimeSlot timeSlot;

                    public TimeSlotBuilder() {
                        this.timeSlot = new TimeSlot();
                    }

                    public TimeSlotBuilder setDays(List<String> days) {
                        this.timeSlot.days = days;

                        return this;
                    }

                    public TimeSlotBuilder setTime(TimeRange time) {
                        this.timeSlot.time = time;

                        return this;
                    }

                    public TimeSlot create() {
                        return this.timeSlot;
                    }
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class TimeRange implements Serializable {
                    @JsonProperty("start_time")
                    private LocalDateTime startTime;

                    @JsonProperty("end_time")
                    private LocalDateTime endTime;

                    public TimeRange() {

                    }

                    public TimeRange(LocalDateTime startTime, LocalDateTime endTime) {
                        this.startTime = startTime;
                        this.endTime = endTime;
                    }

                    public LocalDateTime getStartTime() {
                        return startTime;
                    }

                    public void setStartTime(LocalDateTime startTime) {
                        this.startTime = startTime;
                    }

                    public LocalDateTime getEndTime() {
                        return endTime;
                    }

                    public void setEndTime(LocalDateTime endTime) {
                        this.endTime = endTime;
                    }

                    public TimeRangeBuilder builder() {
                        return new TimeRangeBuilder();
                    }

                    @Override
                    public String toString() {
                        return "TimeRange{" +
                                "startTime='" + startTime + '\'' +
                                ", endTime='" + endTime + '\'' +
                                '}';
                    }

                    public static class TimeRangeBuilder {
                        private final TimeRange timeRange;

                        public TimeRangeBuilder() {
                            this.timeRange = new TimeRange();
                        }

                        public TimeRangeBuilder setStartTime(LocalDateTime startTime) {
                            this.timeRange.startTime = startTime;

                            return this;
                        }

                        public TimeRangeBuilder setEndTime(LocalDateTime endTime) {
                            this.timeRange.endTime = endTime;

                            return this;
                        }

                        public TimeRange create() {
                            return this.timeRange;
                        }
                    }
                }
            }
        }
    }

    public static AdGroup findById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIFindAdGroupById(nextDoorAPIAuth, id).execute();
    }

    public static NextDoorAPIFindAdGroupStatsById findAdGroupStatsById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIFindAdGroupStatsById(nextDoorAPIAuth, id);
    }

    static class NextDoorAPIFindAdGroupById extends NextDoorAPIRequest<AdGroup> implements NextDoorAPIExecute<AdGroup> {
        private final String id;

        public NextDoorAPIFindAdGroupById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(AdGroup.class, nextDoorAPIAuth);


            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "adgroup/get/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdGroup execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AdGroupNotFoundException("Cannot find Ad group with id: " + this.id + " because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdGroupNotFoundException extends APIRequestException {
            public AdGroupNotFoundException() {
            }

            public AdGroupNotFoundException(String s) {
                super(s);
            }

            public AdGroupNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdGroupNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdGroupNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIFindAdGroupStatsById extends NextDoorAPIRequest<AdGroupStats> implements NextDoorAPIExecute<AdGroupStats> {
        private final String id;

        public NextDoorAPIFindAdGroupStatsById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(AdGroupStats.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(id, "id");

            this.setParamInternal("id", id);
            this.id = id;
        }

        public NextDoorAPIFindAdGroupStatsById setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIFindAdGroupStatsById setStartTime(Date startTime) {
            return setStartTime(NextDoorUtil.formatDate(startTime));
        }

        public NextDoorAPIFindAdGroupStatsById setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIFindAdGroupStatsById setEndTime(Date endTime) {
            return setEndTime(NextDoorUtil.formatDate(endTime));
        }

        public NextDoorAPIFindAdGroupStatsById setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "adgroup/get/" + this.id + "/stats";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdGroupStats execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdGroupStatsNotFound("Can't find Ad group stats by ID " + this.id + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdGroupStatsNotFound extends APIRequestException {
            public AdGroupStatsNotFound() {
            }

            public AdGroupStatsNotFound(String s) {
                super(s);
            }

            public AdGroupStatsNotFound(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdGroupStatsNotFound(Throwable throwable) {
                super(throwable);
            }

            public AdGroupStatsNotFound(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
