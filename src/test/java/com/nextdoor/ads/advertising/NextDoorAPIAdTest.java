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

import com.nextdoor.api.advertising.NextDoorAPIAd;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.UserStatus;
import com.nextdoor.models.advertising.ad.Ad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextDoorAPIAdTest {

    @Test
    public void testCreateAd_Success() throws APIRequestException {
        NextDoorAPIAuth auth = new NextDoorAPIAuth("ACCESS_TOKEN");
        NextDoorAPIAd apiAd = new NextDoorAPIAd(auth);

        Ad ad = apiAd.createAd()
                .setName("Sample Ad")
                .setAdvertiserId("398256777252046131")
                .setAdGroupId("67890")
                .setCreativeId("creativeId123")
                .execute();

        assertNotNull(ad, "Ad should not be null on successful creation");
        assertEquals("Sample Ad", ad.getName(), "Ad name should match");
        assertEquals("12345", ad.getAdvertiserId(), "Advertiser ID should match");
        assertEquals("67890", ad.getAdGroupId(), "Ad Group ID should match");
        assertEquals("creativeId123", ad.getCreativeId(), "Creative ID should match");
    }

    @Test
    public void testCreateAd_MissingFields() {
        NextDoorAPIAd apiAd = new NextDoorAPIAd(new NextDoorAPIAuth("ACCESS_TOKEN"));

        Exception exception = assertThrows(APIRequestException.class, () -> {
            apiAd.createAd()
                    .setAdvertiserId("12345")
                    .execute();
        });
        assertTrue(exception.getMessage().contains("name"));
    }

    @Test
    public void testUpdateAd_Success() throws APIRequestException {
        NextDoorAPIAuth auth = new NextDoorAPIAuth("ACCESS_TOKEN");
        NextDoorAPIAd apiAd = new NextDoorAPIAd(auth);

        Ad ad = apiAd.updateAd()
                .setId("adId123")
                .setName("Updated Ad Name")
                .setAdvertiserId("12345")
                .setCreativeId("creativeId456")
                .execute();

        assertNotNull(ad, "Ad should not be null on successful update");
        assertEquals("Updated Ad Name", ad.getName(), "Updated ad name should match");
        assertEquals("12345", ad.getAdvertiserId(), "Advertiser ID should match");
        assertEquals("creativeId456", ad.getCreativeId(), "Creative ID should match");
    }

    @Test
    public void testUpdateAd_InvalidId() {
        NextDoorAPIAd apiAd = new NextDoorAPIAd(new NextDoorAPIAuth("ACCESS_TOKEN"));

        Exception exception = assertThrows(APIRequestException.class, () -> {
            apiAd.updateAd()
                    .setId("invalidId")
                    .execute();
        });
        assertTrue(exception.getMessage().contains("Can't update Ad"));
    }

    @Test
    public void testUpdateAdStatus_Success() throws APIRequestException {
        NextDoorAPIAuth auth = new NextDoorAPIAuth("ACCESS_TOKEN");
        NextDoorAPIAd apiAd = new NextDoorAPIAd(auth);

        Ad ad = apiAd.updateAdStatus()
                .setId("adId123")
                .setAdvertiserId("12345")
                .setUserStatus(UserStatus.ACTIVE)
                .execute();

        assertNotNull(ad, "Ad should not be null on successful status update");
        assertEquals(UserStatus.ACTIVE, ad.getUserStatus(), "Ad status should match the updated status");
    }

    @Test
    public void testUpdateAdStatus_Unauthorized() {
        NextDoorAPIAuth auth = new NextDoorAPIAuth("ACCESS_TOKEN");
        NextDoorAPIAd apiAd = new NextDoorAPIAd(auth);

        APIRequestException exception = assertThrows(APIRequestException.class, () -> {
            apiAd.updateAdStatus()
                    .setId("adId123")
                    .setAdvertiserId("12345")
                    .setUserStatus(UserStatus.INACTIVE)
                    .execute();
        });
        assertTrue(exception.getMessage().contains("Unauthorized"), "Exception should indicate unauthorized access");
    }
}