/*
 * Copyright (c) 2024 Nika Beridze
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
