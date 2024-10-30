package com.nextdoor.models.sharingcontent.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.api.sharingcontent.NextDoorAPIPosts;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post extends NextDoorModel implements Serializable {
    @JsonProperty("result")
    private String result;

    @JsonProperty("share_link")
    private String linkToPost;

    public Post() {

    }

    public Post(String result, String linkToPost) {
        this.result = result;
        this.linkToPost = linkToPost;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLinkToPost() {
        return linkToPost;
    }

    public void setLinkToPost(String linkToPost) {
        this.linkToPost = linkToPost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "result='" + result + '\'' +
                ", linkToPost='" + linkToPost + '\'' +
                '}';
    }

    public static ExistedPost findById(String postId, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        PostsData postsData = new NextDoorAPIPosts(nextDoorAPIAuth).getAllPosts().execute();
        List<ExistedPost> filteredPost = postsData.getPosts()
                .stream()
                .filter(elem -> elem.getId().equals(postId)).collect(Collectors.toList());

        if (filteredPost.isEmpty()) {
            throw new APIRequestException("No post with id " + postId + " found");
        }

        ExistedPost existedPost = filteredPost.get(0);
        existedPost.setNextDoorAPIAuth(nextDoorAPIAuth);
        return existedPost;
    }
}
