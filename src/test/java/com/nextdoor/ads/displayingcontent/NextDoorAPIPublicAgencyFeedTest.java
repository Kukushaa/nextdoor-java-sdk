package com.nextdoor.ads.displayingcontent;

import com.nextdoor.api.displayingcontent.NextDoorAPIPublicAgencyFeed;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.models.displayingcontent.publicagencyfeed.AgencyPosts;
import com.nextdoor.models.displayingcontent.publicagencyfeed.LocationListByState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextDoorAPIPublicAgencyFeedTest {
    private static final String STATE_ID = "valid-state-id";
    private static final String AGENCY_ID = "valid-agency-id";

    private NextDoorAPIPublicAgencyFeed.NextDoorAPIAgencyListByState createAgencyListRequest(String stateId) {
        return new NextDoorAPIPublicAgencyFeed.NextDoorAPIAgencyListByState(NextDoorAPIAuth.defaultNextDoorAPIAuth())
                .setStateId(stateId);
    }

    private NextDoorAPIPublicAgencyFeed.NextDoorAPIPostsForAnAgency createPostsRequest(String agencyId) {
        return new NextDoorAPIPublicAgencyFeed.NextDoorAPIPostsForAnAgency(NextDoorAPIAuth.defaultNextDoorAPIAuth())
                .setId(agencyId);
    }

    @Test
    public void testAgencyListByState() {
        try {
            NextDoorAPIPublicAgencyFeed.NextDoorAPIAgencyListByState agencyListRequest = createAgencyListRequest(STATE_ID);
            LocationListByState locationList = agencyListRequest.execute();

            assertNotNull(locationList, "Expected non-null location list by state.");
            assertAll("Location list validations",
                    () -> assertFalse(locationList.getCity().isEmpty(), "Expected non-empty city."),
                    () -> assertFalse(locationList.getCountry().isEmpty(), "Expected non-empty country."),
                    () -> assertFalse(locationList.getName().isEmpty(), "Expected non-empty name."),
                    () -> assertNotNull(locationList.getState(), "Expected non-null state.")
            );

        } catch (Exception e) {
            fail("API call failed: " + e.getMessage());
        }
    }

    @Test
    public void testPostsForAgency() {
        try {
            NextDoorAPIPublicAgencyFeed.NextDoorAPIPostsForAnAgency postsRequest = createPostsRequest(AGENCY_ID);
            AgencyPosts agencyPosts = postsRequest.execute();

            assertNotNull(agencyPosts, "Expected non-null agency posts.");
            assertFalse(agencyPosts.getPosts().isEmpty(), "Expected non-empty posts list.");
        } catch (Exception e) {
            fail("API call failed: " + e.getMessage());
        }
    }
}
