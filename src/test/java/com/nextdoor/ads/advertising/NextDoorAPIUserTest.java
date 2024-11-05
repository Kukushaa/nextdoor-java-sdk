/*
 * Copyright (c) 2024 Ia Intskirveli
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
