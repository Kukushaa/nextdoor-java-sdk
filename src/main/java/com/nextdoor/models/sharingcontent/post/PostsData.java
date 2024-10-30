package com.nextdoor.models.sharingcontent.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostsData extends NextDoorModel implements Serializable {
    @JsonProperty("posts")
    private List<ExistedPost> posts;

    @JsonProperty("posts_length")
    private int postsLength;

    public PostsData() {
    }

    public PostsData(List<ExistedPost> posts, int postsLength) {
        this.posts = posts;
        this.postsLength = postsLength;
    }

    public List<ExistedPost> getPosts() {
        return posts;
    }

    public void setPosts(List<ExistedPost> posts) {
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
        return "Posts{" +
                "posts=" + posts +
                ", postsLength=" + postsLength +
                '}';
    }
}