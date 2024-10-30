package com.nextdoor.models.advertising.advertiser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.NextDoorModel;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_ADS_API_URL;

public class Advertiser extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    public String id;

    @JsonProperty("profile_id")
    public String profileId;

    @JsonProperty("name")
    public String advertiserName;

    @JsonProperty("website_url")
    public String websiteUrl;

    @JsonProperty("categories")
    public List<String> categories;

    @JsonProperty("address")
    public Address address;

    @JsonProperty("billing_limit")
    public String billingLimit;

    @JsonProperty("payment_profile_id")
    public String paymentProfileId;

    @JsonProperty("bill_to_payment_profile_id")
    public String billToPaymentProfileId;

    @JsonProperty("account_balance")
    public String accountBalance;

    public Advertiser() {

    }

    public Advertiser(String id, String profileId, String advertiserName, String websiteUrl, List<String> categories, Address address, String billingLimit, String paymentProfileId, String billToPaymentProfileId, String accountBalance) {
        this.id = id;
        this.profileId = profileId;
        this.advertiserName = advertiserName;
        this.websiteUrl = websiteUrl;
        this.categories = categories;
        this.address = address;
        this.billingLimit = billingLimit;
        this.paymentProfileId = paymentProfileId;
        this.billToPaymentProfileId = billToPaymentProfileId;
        this.accountBalance = accountBalance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBillingLimit() {
        return billingLimit;
    }

    public void setBillingLimit(String billingLimit) {
        this.billingLimit = billingLimit;
    }

    public String getPaymentProfileId() {
        return paymentProfileId;
    }

    public void setPaymentProfileId(String paymentProfileId) {
        this.paymentProfileId = paymentProfileId;
    }

    public String getBillToPaymentProfileId() {
        return billToPaymentProfileId;
    }

    public void setBillToPaymentProfileId(String billToPaymentProfileId) {
        this.billToPaymentProfileId = billToPaymentProfileId;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public static Advertiser findById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIFindAdvertiserById(nextDoorAPIAuth, id).execute();
    }

    static class NextDoorAPIFindAdvertiserById extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        private final String id;

        public NextDoorAPIFindAdvertiserById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(Advertiser.class, nextDoorAPIAuth);


            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/get/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Advertiser execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AdvertiserNotFoundException("Cannot find Advertiser by ID: " + this.id + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserNotFoundException extends APIRequestException {
            public AdvertiserNotFoundException() {
            }

            public AdvertiserNotFoundException(String s) {
                super(s);
            }

            public AdvertiserNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class Address {
        @JsonProperty("street_address")
        public String streetAddress;

        @JsonProperty("street_address_2")
        public String streetAddress2;

        @JsonProperty("city")
        public String city;

        @JsonProperty("state")
        public String state;

        @JsonProperty("postal_code")
        public String postalCode;

        @JsonProperty("country")
        public String country;

        public Address() {

        }

        public Address(String streetAddress, String streetAddress2, String city, String state, String postalCode, String country) {
            this.streetAddress = streetAddress;
            this.streetAddress2 = streetAddress2;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
            this.country = country;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getStreetAddress2() {
            return streetAddress2;
        }

        public void setStreetAddress2(String streetAddress2) {
            this.streetAddress2 = streetAddress2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    public static Advertiser findById(NextDoorAPIAuth nextDoorAPIAuth, String id) throws APIRequestException {
        return new NextDoorAPIGetAdvertiserById(nextDoorAPIAuth, id).execute();
    }

    public static NextDoorAPIAdvertiserFindStatsById findStatsById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
        return new NextDoorAPIAdvertiserFindStatsById(nextDoorAPIAuth, id);
    }

    static class NextDoorAPIGetAdvertiserById extends NextDoorAPIRequest<Advertiser> implements NextDoorAPIExecute<Advertiser> {
        private final String advertiserId;

        public NextDoorAPIGetAdvertiserById(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId) {
            super(Advertiser.class, nextDoorAPIAuth);


            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
            this.advertiserId = advertiserId;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "get/" + this.advertiserId;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Advertiser execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AdvertiserNotFoundException("Cannot get Advertiser by ID: " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserNotFoundException extends APIRequestException {
            public AdvertiserNotFoundException() {
            }

            public AdvertiserNotFoundException(String s) {
                super(s);
            }

            public AdvertiserNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIAdvertiserFindStatsById extends NextDoorAPIRequest<AdvertuserStatsById> implements NextDoorAPIExecute<AdvertuserStatsById> {
        private final String id;

        public NextDoorAPIAdvertiserFindStatsById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(AdvertuserStatsById.class, nextDoorAPIAuth);


            NextDoorUtil.ensureStringNotNull(id, "id");

            this.id = id;
        }

        public NextDoorAPIAdvertiserFindStatsById setAdvertiserId(String advertiserId) {
            this.setParamInternal("advertiser_id", advertiserId);

            return this;
        }

        public NextDoorAPIAdvertiserFindStatsById setStartTime(Date startTime) {
            return setStartTime(NextDoorUtil.formatDate(startTime));
        }

        public NextDoorAPIAdvertiserFindStatsById setStartTime(String startTime) {
            this.setParamInternal("start_time", startTime);

            return this;
        }

        public NextDoorAPIAdvertiserFindStatsById setEndTime(Date endTime) {
            return setEndTime(NextDoorUtil.formatDate(endTime));
        }

        public NextDoorAPIAdvertiserFindStatsById setEndTime(String endTime) {
            this.setParamInternal("end_time", endTime);

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_ADS_API_URL + "advertiser/get/" + this.id + "/stats";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AdvertuserStatsById execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new AdvertiserStatsByIdNotFoundException("Can't find Advertiser stats by ID " + this.id + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class AdvertiserStatsByIdNotFoundException extends APIRequestException {
            public AdvertiserStatsByIdNotFoundException() {
            }

            public AdvertiserStatsByIdNotFoundException(String s) {
                super(s);
            }

            public AdvertiserStatsByIdNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AdvertiserStatsByIdNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AdvertiserStatsByIdNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}