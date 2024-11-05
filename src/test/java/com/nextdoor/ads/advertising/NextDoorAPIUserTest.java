package com.nextdoor.ads.advertising;

import com.nextdoor.api.advertising.NextDoorAPIUser;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.advertising.user.AdUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextDoorAPIUserTest {

    @Test
    public void testUserAdvertiser() {
        String accessTokenString = "MY_ACESS_TOKEN";
        NextDoorAPIAuth accessToken = new NextDoorAPIAuth(accessTokenString);
        AdUser adUser;

        try {
            adUser = new NextDoorAPIUser(accessToken).getUserInfo().execute();
        } catch (APIRequestException e) {
            throw new RuntimeException("Failed to retrieve user info: " + e.getMessage(), e);
        }
        assertAdUserIsValid(adUser);
    }

    private void assertAdUserIsValid(AdUser adUser) {
        assertNotNull(adUser, "The AdUser object should not be null.");
        assertEquals(AdUser.class, adUser.getClass(), "Returned object should be of type AdUser.");

        AdUser.CurrentUser currentUser = adUser.getCurrentUser();
        assertNotNull(currentUser, "CurrentUser should not be null.");
        assertTrue(currentUser.isEmailConfirmed(), "Email should be confirmed.");

        AdUser.Profile profile = adUser.getCurrentProfile();
        assertNotNull(profile, "Profile should not be null.");
        assertNotNull(profile.getId(), "Profile ID should not be null.");
        assertNotNull(profile.getAssociatedUserIds(), "Associated user IDs should not be null.");
    }
}
