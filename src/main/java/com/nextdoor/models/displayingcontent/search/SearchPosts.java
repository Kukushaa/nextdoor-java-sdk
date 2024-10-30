package com.nextdoor.models.displayingcontent.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPosts extends NextDoorModel implements Serializable {
    @JsonProperty("posts")
    private List<SearchPost> posts;

    @JsonProperty("posts_length")
    private int postsLength;

    public SearchPosts() {

    }

    public SearchPosts(List<SearchPost> posts, int postsLength) {
        this.posts = posts;
        this.postsLength = postsLength;
    }

    public List<SearchPost> getPosts() {
        return posts;
    }

    public void setPosts(List<SearchPost> posts) {
        this.posts = posts;
    }

    public int getPostsLength() {
        return postsLength;
    }

    public void setPostsLength(int postsLength) {
        this.postsLength = postsLength;
    }

    @Override
    public String toString() {
        return "SearchPosts{" +
                "posts=" + posts +
                ", postsLength=" + postsLength +
                '}';
    }
}
