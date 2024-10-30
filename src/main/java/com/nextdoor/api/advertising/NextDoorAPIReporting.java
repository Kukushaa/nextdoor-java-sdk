package com.nextdoor.api.advertising;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.advertising.reporting.AdReporting;
import com.nextdoor.models.advertising.reporting.AdScheduledReport;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class NextDoorAPIReporting extends NextDoorAPIRequestNode {
    public NextDoorAPIReporting() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIReporting(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIReportingCreate createReport() {
        return new NextDoorAPIReportingCreate(this.nextDoorAPIAuth);
    }

    public NextDoorAPICreateScheduledReporting createScheduledReporting() {
        return new NextDoorAPICreateScheduledReporting(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPIReportingCreate extends NextDoorAPIRequest<AdReporting> implements NextDoorAPIExecute<AdReporting> {
        public NextDoorAPIReportingCreate(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdReporting.class, nextDoorAPIAuth);
        }

        public NextDoorAPIReportingCreate setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIReportingCreate setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIReportingCreate setRecipientEmails(Collection<String> recipientEmails) {
            this.setParamInternal("recipient_emails", recipientEmails);

            return this;
        }

        public NextDoorAPIReportingCreate setDimensionGranularity(Collection<AdScheduledReport.DimesionGranularity> dimensionGranularity) {
            this.setParamInternal("dimension_granularity", dimensionGranularity);

            return this;
        }

        public NextDoorAPIReportingCreate setTimeGranularity(Collection<AdScheduledReport.TimeGranularity> timeGranularity) {
            this.setParamInternal("time_granularity", timeGranularity);

            return this;
        }

        public NextDoorAPIReportingCreate setMetrics(Collection<AdScheduledReport.Metrics> metrics) {
            this.setParamInternal("metrics", metrics);

            return this;
        }

        public NextDoorAPIReportingCreate setCampaignIds(Collection<String> campaignIds) {
            this.setParamInternal("campaign_ids", campaignIds);

            return this;
        }

        public NextDoorAPIReportingCreate setAdIds(Collection<String> adIds) {
            this.setParamInternal("ad_ids", adIds);

            return this;
        }

        public NextDoorAPIReportingCreate setStartTime(Date startTime) {
            this.setParamInternal("start_time", NextDoorUtil.formatDate(startTime));

            return this;
        }

        public NextDoorAPIReportingCreate setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIReportingCreate setEndTime(Date endTime) {
            this.setParamInternal("end_time", NextDoorUtil.formatDate(endTime));

            return this;
        }

        public NextDoorAPIReportingCreate setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "reporting/create";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdReporting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new AdReportingCreateException("Cannot create Reporting, because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdReportingCreateException extends APIRequestException {
            public AdReportingCreateException() {
            }

            public AdReportingCreateException(String s) {
                super(s);
            }

            public AdReportingCreateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdReportingCreateException(Throwable throwable) {
                super(throwable);
            }

            public AdReportingCreateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPICreateScheduledReporting extends NextDoorAPIRequest<AdScheduledReport> implements NextDoorAPIExecute<AdScheduledReport> {
        public NextDoorAPICreateScheduledReporting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdScheduledReport.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateScheduledReporting setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPICreateScheduledReporting setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateScheduledReporting setSchedule(AdScheduledReport.Schedule schedule) {
            this.setParamInternal("schedule", schedule.name());

            return this;
        }

        public NextDoorAPICreateScheduledReporting setTimeZone(String timeZone) {
            this.setParamInternal("time_zone", timeZone);

            return this;
        }

        public NextDoorAPICreateScheduledReporting setTimeZone(TimeZone timeZone) {
            return setTimeZone(timeZone.getID());
        }

        public NextDoorAPICreateScheduledReporting setRecipientEmails(Collection<String> recipientEmails) {
            this.setParamInternal("recipient_emails", recipientEmails);

            return this;
        }

        public NextDoorAPICreateScheduledReporting setDimensionGranularity(Collection<AdScheduledReport.DimesionGranularity> dimensionGranularity) {
            this.setParamInternal("dimension_granularity", dimensionGranularity);

            return this;
        }

        public NextDoorAPICreateScheduledReporting setTimeGranularity(AdScheduledReport.TimeGranularity timeGranularity) {
            this.setParamInternal("time_granularity", timeGranularity.name());

            return this;
        }

        public NextDoorAPICreateScheduledReporting setMetrics(Collection<AdScheduledReport.Metrics> metrics) {
            this.setParamInternal("metrics", metrics);

            return this;
        }

        public NextDoorAPICreateScheduledReporting setCampaignIds(Collection<String> campaignIds) {
            this.setParamInternal("campaign_ids", campaignIds);

            return this;
        }

        public NextDoorAPICreateScheduledReporting setAdGroupIds(Collection<String> adGroupIds) {
            this.setParamInternal("adgroup_ids", adGroupIds);

            return this;
        }

        public NextDoorAPICreateScheduledReporting setAdIds(Collection<String> adIds) {
            this.setParamInternal("ad_ids", adIds);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "reporting/scheduled/create";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdScheduledReport execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new ScheduledReportCreateException("Cannot create Scheduled Reporting, because of: " + e.getLocalizedMessage());
            }
        }

        public static class ScheduledReportCreateException extends APIRequestException {
            public ScheduledReportCreateException() {
            }

            public ScheduledReportCreateException(String s) {
                super(s);
            }

            public ScheduledReportCreateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public ScheduledReportCreateException(Throwable throwable) {
                super(throwable);
            }

            public ScheduledReportCreateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIArchiveScheduledReporting extends NextDoorAPIRequest<AdScheduledReport> implements NextDoorAPIExecute<AdScheduledReport> {
        public NextDoorAPIArchiveScheduledReporting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AdScheduledReport.class, nextDoorAPIAuth);
        }

        public NextDoorAPIArchiveScheduledReporting setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIArchiveScheduledReporting setId(String id) {
            this.setParamInternal("id", id);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "reporting/scheduled/archive";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdScheduledReport execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new ScheduledReportArchivedException("Cannot archive Scheduled Reporting, because of: " + e.getLocalizedMessage());
            }
        }

        public static class ScheduledReportArchivedException extends APIRequestException {
            public ScheduledReportArchivedException() {
            }

            public ScheduledReportArchivedException(String s) {
                super(s);
            }

            public ScheduledReportArchivedException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public ScheduledReportArchivedException(Throwable throwable) {
                super(throwable);
            }

            public ScheduledReportArchivedException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
