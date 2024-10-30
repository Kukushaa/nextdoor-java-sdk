package com.nextdoor.api.advertising;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.PaginationParameters;
import com.nextdoor.models.advertising.tareting.*;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

import java.util.Collection;

public class NextDoorAPIAdvertisingTargeting extends NextDoorAPIRequestNode {
    public static final String TARGETING_PREFIX = "targeting/";

    public NextDoorAPIAdvertisingTargeting() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIAdvertisingTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIGeoStateList getGeoStateList() {
        return new NextDoorAPIGeoStateList(this.nextDoorAPIAuth);
    }

    public NextDoorAPIGeoCityList getGeoCityList() {
        return new NextDoorAPIGeoCityList(this.nextDoorAPIAuth);
    }

    public NextDoorAPIGeoDMAList getGeoDMAList() {
        return new NextDoorAPIGeoDMAList(this.nextDoorAPIAuth);
    }

    public NextDoorAPIGetTargetingGeoPostalCodeBulkMatch getTargetingGeoPostalCodeBulkMatch() {
        return new NextDoorAPIGetTargetingGeoPostalCodeBulkMatch(this.nextDoorAPIAuth);
    }

    public NextDoorAPIPostalCodeListTargeting getTargetingPostalCodeListTargeting() {
        return new NextDoorAPIPostalCodeListTargeting(this.nextDoorAPIAuth);
    }

    public NextDoorAPIDemographicsGenderTargeting getDemographicsGenderTargeting() {
        return new NextDoorAPIDemographicsGenderTargeting(this.nextDoorAPIAuth);
    }

    public NextDoorAPIDemographicsAgeTargeting getDemographicsAgeTargeting() {
        return new NextDoorAPIDemographicsAgeTargeting(this.nextDoorAPIAuth);
    }

    public NextDoorAPIDemoraphicsHomeownershipTargeting getDemographicsHomeownershipTargeting() {
        return new NextDoorAPIDemoraphicsHomeownershipTargeting(this.nextDoorAPIAuth);
    }

    public NextDoorAPIDemographicIncomeTargeting getDemographicsIncomeTargeting() {
        return new NextDoorAPIDemographicIncomeTargeting(this.nextDoorAPIAuth);
    }

    public NextDoorAPIInterestTargetingList getInterestTargetingList() {
        return new NextDoorAPIInterestTargetingList(this.nextDoorAPIAuth);
    }

    public NextDoorAPIDeviceList getDeviceListTargeting() {
        return new NextDoorAPIDeviceList(this.nextDoorAPIAuth);
    }

    public static class NextDoorAPIGeoStateList extends NextDoorAPIRequest<StateTargeting> implements NextDoorAPIExecute<StateTargeting> {
        public NextDoorAPIGeoStateList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(StateTargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "geo/state/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public StateTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new StateTargetingNotFoundException("Cannot search targeting with state because of: " + e.getLocalizedMessage());
            }
        }

        public static class StateTargetingNotFoundException extends APIRequestException {
            public StateTargetingNotFoundException() {
            }

            public StateTargetingNotFoundException(String s) {
                super(s);
            }

            public StateTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public StateTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public StateTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIGeoCityList extends NextDoorAPIRequest<CityTargeting> implements NextDoorAPIExecute<CityTargeting> {
        public NextDoorAPIGeoCityList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(CityTargeting.class, nextDoorAPIAuth);
        }

        public NextDoorAPIGeoCityList setPaginationParameters(PaginationParameters paginationParameters) {
            this.setParamInternal("pagination_parameters", paginationParameters);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "geo/city/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public CityTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CityTargetingNotFoundException("Can't find City targeting, because of: " + e.getLocalizedMessage());
            }
        }

        public static class CityTargetingNotFoundException extends APIRequestException {
            public CityTargetingNotFoundException() {
            }

            public CityTargetingNotFoundException(String s) {
                super(s);
            }

            public CityTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CityTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public CityTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIGeoDMAList extends NextDoorAPIRequest<DMATargeting> implements NextDoorAPIExecute<DMATargeting> {
        public NextDoorAPIGeoDMAList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(DMATargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "geo/dma/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public DMATargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new DMATargetingNotFoundException("Cannot search targeting with DMA because of: " + e.getLocalizedMessage());
            }
        }

        public static class DMATargetingNotFoundException extends APIRequestException {
            public DMATargetingNotFoundException() {
            }

            public DMATargetingNotFoundException(String s) {
                super(s);
            }

            public DMATargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public DMATargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public DMATargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIGetTargetingGeoPostalCodeBulkMatch extends NextDoorAPIRequest<PostalCodeBulkMatchTargeting> implements NextDoorAPIExecute<PostalCodeBulkMatchTargeting> {
        public NextDoorAPIGetTargetingGeoPostalCodeBulkMatch(NextDoorAPIAuth nextDoorAPIAuth) {
            super(PostalCodeBulkMatchTargeting.class, nextDoorAPIAuth);
        }

        public NextDoorAPIGetTargetingGeoPostalCodeBulkMatch setPostalCodes(Collection<String> postalCodes) {
            String formattedPostalCodes = String.join(",", postalCodes);

            this.setParamInternal("postal_codes", formattedPostalCodes);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "geo/postalcode/bulk_match";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public PostalCodeBulkMatchTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new PostalCodeBulkMatchNotFoundException("Can't find Postalcode bulk match, because of: " + e.getLocalizedMessage());
            }
        }

        public static class PostalCodeBulkMatchNotFoundException extends APIRequestException {
            public PostalCodeBulkMatchNotFoundException() {
            }

            public PostalCodeBulkMatchNotFoundException(String s) {
                super(s);
            }

            public PostalCodeBulkMatchNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public PostalCodeBulkMatchNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public PostalCodeBulkMatchNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIPostalCodeListTargeting extends NextDoorAPIRequest<PostalcodeListTargeting> implements NextDoorAPIExecute<PostalcodeListTargeting> {
        public NextDoorAPIPostalCodeListTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(PostalcodeListTargeting.class, nextDoorAPIAuth);
        }

        public NextDoorAPIPostalCodeListTargeting setPaginationParameters(PaginationParameters paginationParameters) {
            this.setParamInternal("pagination_parameters", paginationParameters);

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "geo/postalcode/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public PostalcodeListTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new PostalCodeListFoundException("Can't find Postal code list, because of: " + e.getLocalizedMessage());
            }
        }

        public static class PostalCodeListFoundException extends APIRequestException {
            public PostalCodeListFoundException() {
            }

            public PostalCodeListFoundException(String s) {
                super(s);
            }

            public PostalCodeListFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public PostalCodeListFoundException(Throwable throwable) {
                super(throwable);
            }

            public PostalCodeListFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDemographicsGenderTargeting extends NextDoorAPIRequest<GenderTargeting> implements NextDoorAPIExecute<GenderTargeting> {
        public NextDoorAPIDemographicsGenderTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(GenderTargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "demographics/gender/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public GenderTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new GenderTargetingNotFoundException("Cannot search targeting with gender because of: " + e.getLocalizedMessage());
            }
        }

        public static class GenderTargetingNotFoundException extends APIRequestException {
            public GenderTargetingNotFoundException() {
            }

            public GenderTargetingNotFoundException(String s) {
                super(s);
            }

            public GenderTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public GenderTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public GenderTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDemographicsAgeTargeting extends NextDoorAPIRequest<AgeTargeting> implements NextDoorAPIExecute<AgeTargeting> {
        public NextDoorAPIDemographicsAgeTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AgeTargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "demographics/age/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AgeTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AgeTargetingNotFoundException("Cannot search targeting with gender because of: " + e.getLocalizedMessage());
            }
        }

        public static class AgeTargetingNotFoundException extends APIRequestException {
            public AgeTargetingNotFoundException() {
            }

            public AgeTargetingNotFoundException(String s) {
                super(s);
            }

            public AgeTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AgeTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AgeTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDemoraphicsHomeownershipTargeting extends NextDoorAPIRequest<HomeownershipTargeting> implements NextDoorAPIExecute<HomeownershipTargeting> {
        public NextDoorAPIDemoraphicsHomeownershipTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(HomeownershipTargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "demographics/homeownership/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public HomeownershipTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new HomeownershipTargetingNotFoundException("Cannot search targeting with home ownership because of: " + e.getLocalizedMessage());
            }
        }

        public static class HomeownershipTargetingNotFoundException extends APIRequestException {
            public HomeownershipTargetingNotFoundException() {
            }

            public HomeownershipTargetingNotFoundException(String s) {
                super(s);
            }

            public HomeownershipTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public HomeownershipTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public HomeownershipTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDemographicIncomeTargeting extends NextDoorAPIRequest<IncomeTargeting> implements NextDoorAPIExecute<IncomeTargeting> {
        public NextDoorAPIDemographicIncomeTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(IncomeTargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "demographics/income/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public IncomeTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new IcnomeTargetingNotFoundException("Cannot search targeting with income because of: " + e.getLocalizedMessage());
            }
        }

        public static class IcnomeTargetingNotFoundException extends APIRequestException {
            public IcnomeTargetingNotFoundException() {
            }

            public IcnomeTargetingNotFoundException(String s) {
                super(s);
            }

            public IcnomeTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public IcnomeTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public IcnomeTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIInterestTargetingList extends NextDoorAPIRequest<InterestTargeting> implements NextDoorAPIExecute<InterestTargeting> {
        public NextDoorAPIInterestTargetingList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(InterestTargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "targeting/interest/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public InterestTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new InterestTargetingNotFoundException("Cannot search targeting with interest because of: " + e.getLocalizedMessage());
            }
        }

        public static class InterestTargetingNotFoundException extends APIRequestException {
            public InterestTargetingNotFoundException() {
            }

            public InterestTargetingNotFoundException(String s) {
                super(s);
            }

            public InterestTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public InterestTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public InterestTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDeviceList extends NextDoorAPIRequest<DeviceTargeting> implements NextDoorAPIExecute<DeviceTargeting> {
        public NextDoorAPIDeviceList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(DeviceTargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "device/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public DeviceTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new DeviceTargetingNotFoundException("Cannot search Device targeting, because of: " + e.getLocalizedMessage());
            }
        }

        public static class DeviceTargetingNotFoundException extends APIRequestException {
            public DeviceTargetingNotFoundException() {
            }

            public DeviceTargetingNotFoundException(String s) {
                super(s);
            }

            public DeviceTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public DeviceTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public DeviceTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}