package com.nextdoor.ads.displayingcontent;

import com.nextdoor.api.displayingcontent.NextDoorAPITrendingPosts;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.models.displayingcontent.trendingposts.City;
import com.nextdoor.models.displayingcontent.trendingposts.TargetingPostsCity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NextDoorAPITrendingPostsTest {
    private NextDoorAPITrendingPosts trendingPosts;

    @BeforeEach
    public void setUp() {
        trendingPosts= new NextDoorAPITrendingPosts(new NextDoorAPIAuth("MY_ACCESS_TOKEN"));
    }

    @Test
    public void testSearchPosts() {
        try {
            List<City> cities = trendingPosts.searchPosts().execute();
            assertNotNull(cities, "Expected non-null list of cities.");
            assertFalse(cities.isEmpty(), "Expected at least one city in the result.");

            for (City city : cities) {
                assertNotNull(city.getId(), "Expected each city to have a non-null ID.");
                assertNotNull(city.getCity(), "Expected each city to have a name.");
            }
        } catch (Exception e) {
            fail("API call failed: " + e.getMessage());
        }
    }

    // No response from API docs
//    @Test
//    public void testStateList() {
//        try {
//            List<State> states = trendingPosts.stateList().execute();
//            assertNotNull(states, "Expected non-null list of states.");
//            assertFalse(states.isEmpty(), "Expected at least one state in the result.");
//
//            for (State state : states) {
//                assertNotNull(state.getName(), "Expected each state to have a name.");
//            }
//        } catch (Exception e) {
//            fail("API call failed: " + e.getMessage());
//        }
//    }

    @Test
    public void testTargetingPostsForCity() {
        String cityId = "valid-city-id";
        try {
            TargetingPostsCity cityPosts = trendingPosts.targetingPostsForCity()
                    .setId(cityId)
                    .execute();

            assertNotNull(cityPosts, "Expected non-null targeting posts for city.");

            assertNotNull(cityPosts.getPosts(), "Expected non-null list of posts for the city.");
            assertFalse(cityPosts.getPosts().isEmpty(), "Expected at least one post for the city.");
            cityPosts.getPosts().forEach(post ->
                    assertNotNull(post.getTitle(), "Expected each post to have a title.")
            );
        } catch (Exception e) {
            fail("API call failed: " + e.getMessage());
        }
    }

    // No response from API docs
//    @Test
//    public void testTargetingPostsForStateWithPagination() {
//        String stateId = "valid-state-id";
//        Integer pageNum = 1;
//
//        try {
//            TargetingStateWithPagination statePosts = trendingPosts
//                    .targetingPostsForStateWithPagination()
//                    .setStateId(stateId)
//                    .setPageNum(pageNum)
//                    .execute();
//
//            assertNotNull(statePosts, "Expected non-null targeting posts for state with pagination.");
//            assertEquals(pageNum, statePosts.getPageNumber(), "Expected the page number to match the input.");
//
//            assertNotNull(statePosts.getPosts(), "Expected non-null list of posts for the state.");
//            assertFalse(statePosts.getPosts().isEmpty(), "Expected at least one post for the state on the given page.");
//            statePosts.getPosts().forEach(post ->
//                    assertNotNull(post.getTitle(), "Expected each post to have a title.")
//            );
//        } catch (Exception e) {
//            fail("API call failed: " + e.getMessage());
//        }
//    }
}