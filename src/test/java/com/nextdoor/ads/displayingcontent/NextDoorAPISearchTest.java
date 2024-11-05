package com.nextdoor.ads.displayingcontent;

import com.nextdoor.api.displayingcontent.NextDoorAPISearch;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.displayingcontent.search.SearchBusinesses;
import com.nextdoor.models.displayingcontent.search.SearchEvents;
import com.nextdoor.models.displayingcontent.search.SearchFSFItems;
import com.nextdoor.models.displayingcontent.search.SearchPosts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NextDoorAPISearchTest {

    private NextDoorAPISearch nextDoorAPISearch;

    @BeforeEach
    public void setUp() {
        nextDoorAPISearch = new NextDoorAPISearch(new NextDoorAPIAuth("MY_ACCESS_TOKEN"));
    }

    @Test
    public void testSearchPosts() throws APIRequestException {
        float latitude = 37.453F;
        float longitude = -122.181f;
        float radius = 5.0f;

        NextDoorAPISearch.NextDoorAPISearchPosts searchPosts = nextDoorAPISearch.searchPosts()
                .setLatitude(latitude)
                .setLongitude(longitude)
                .setRadius(radius);
        SearchPosts result = searchPosts.execute();

        assertNotNull(result, "SearchPosts result should not be null");
        assertFalse(result.getPosts().isEmpty(), "Posts list should not be empty");
    }

    @Test
    public void testSearchFSFItems() throws APIRequestException {
        float latitude = 37.7749f;
        float longitude = -122.4194f;
        float radius = 5.0f;

        NextDoorAPISearch.NextDoorAPISearchFSFItems searchFSFItems = nextDoorAPISearch.searchFSFItems()
                .setLatitude(latitude)
                .setLongitude(longitude)
                .setRadius(radius);
        List<SearchFSFItems> result = searchFSFItems.execute();

        assertNotNull(result, "SearchFSFItems result should not be null");
        assertFalse(result.isEmpty(), "FSF items list should not be empty");
    }

    @Test
    public void testSearchEvents() throws APIRequestException {
        float latitude = 37.7749f;
        float longitude = -122.4194f;
        float radius = 5.0f;

        NextDoorAPISearch.NextDoorAPISearchEvents searchEvents = nextDoorAPISearch.searchEvents()
                .setLatitude(latitude)
                .setLongitude(longitude)
                .setRadius(radius);
        List<SearchEvents> result = searchEvents.execute();

        assertNotNull(result, "SearchEvents result should not be null");
        assertFalse(result.isEmpty(), "Events list should not be empty");
    }

    @Test
    public void testSearchBusinesses() throws APIRequestException {
        float latitude = 37.7749f;
        float longitude = -122.4194f;
        float radius = 5.0f;
        String query = "bike shop";

        NextDoorAPISearch.NextDoorAPISearchBusinesses searchBusinesses = nextDoorAPISearch.searchBusinesses()
                .setLatitude(latitude)
                .setLongitude(longitude)
                .setRadius(radius)
                .setQuery(query);
        List<SearchBusinesses> result = searchBusinesses.execute();

        assertNotNull(result, "SearchBusinesses result should not be null");
        assertFalse(result.isEmpty(), "Businesses list should not be empty");
    }
}