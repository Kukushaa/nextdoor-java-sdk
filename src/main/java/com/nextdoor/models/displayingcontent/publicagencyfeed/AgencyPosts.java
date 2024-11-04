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
package com.nextdoor.models.displayingcontent.publicagencyfeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.Author;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgencyPosts extends NextDoorModel implements Serializable {
    @JsonProperty("city_post_count")
    private int cityPostCount;

    @JsonProperty("updated_at_epoch_seconds")
    private long updatedAtEpochSeconds;

    @JsonProperty("posts")
    private List<Post> posts;

    public AgencyPosts() {

    }

    public AgencyPosts(int cityPostCount, long updatedAtEpochSeconds, List<Post> posts) {
        this.cityPostCount = cityPostCount;
        this.updatedAtEpochSeconds = updatedAtEpochSeconds;
        this.posts = posts;
    }

    public int getCityPostCount() {
        return cityPostCount;
    }

    public void setCityPostCount(int cityPostCount) {
        this.cityPostCount = cityPostCount;
    }

    public long getUpdatedAtEpochSeconds() {
        return updatedAtEpochSeconds;
    }

    public void setUpdatedAtEpochSeconds(long updatedAtEpochSeconds) {
        this.updatedAtEpochSeconds = updatedAtEpochSeconds;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "AgencyPosts{" +
                "cityPostCount=" + cityPostCount +
                ", updatedAtEpochSeconds=" + updatedAtEpochSeconds +
                ", posts=" + posts +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Post {
        @JsonProperty("author")
        private Author author;

        @JsonProperty("body")
        private String body;

        @JsonProperty("category")
        private String category;

        @JsonProperty("comments")
        private List<String> comments;

        @JsonProperty("comment_closed")
        private boolean commentClosed;

        @JsonProperty("comment_count")
        private int commentCount;

        @JsonProperty("creation_date_epoch_seconds")
        private long creationDateEpochSeconds;

        @JsonProperty("downvote_count")
        private int downvoteCount;

        @JsonProperty("embed_url")
        private String embedUrl;

        @JsonProperty("has_geo_tag")
        private boolean hasGeoTag;

        @JsonProperty("id")
        private String id;

        @JsonProperty("in_popular_posts_curation")
        private boolean inPopularPostsCuration;

        @JsonProperty("latitude")
        private Double latitude;

        @JsonProperty("like_count")
        private int likeCount;

        @JsonProperty("longitude")
        private Double longitude;

        @JsonProperty("url")
        private String url;

        @JsonProperty("media")
        private List<String> media;

        @JsonProperty("public_post_url")
        private String publicPostUrl;

        @JsonProperty("scope")
        private String scope;

        @JsonProperty("score")
        private int score;

        @JsonProperty("title")
        private String title;

        @JsonProperty("user_entered_subject")
        private boolean userEnteredSubject;

        public Post() {

        }

        public Post(Author author, String body, String category, List<String> comments, boolean commentClosed, int commentCount, long creationDateEpochSeconds, int downvoteCount, String embedUrl, boolean hasGeoTag, String id, boolean inPopularPostsCuration, Double latitude, int likeCount, Double longitude, String url, List<String> media, String publicPostUrl, String scope, int score, String title, boolean userEnteredSubject) {
            this.author = author;
            this.body = body;
            this.category = category;
            this.comments = comments;
            this.commentClosed = commentClosed;
            this.commentCount = commentCount;
            this.creationDateEpochSeconds = creationDateEpochSeconds;
            this.downvoteCount = downvoteCount;
            this.embedUrl = embedUrl;
            this.hasGeoTag = hasGeoTag;
            this.id = id;
            this.inPopularPostsCuration = inPopularPostsCuration;
            this.latitude = latitude;
            this.likeCount = likeCount;
            this.longitude = longitude;
            this.url = url;
            this.media = media;
            this.publicPostUrl = publicPostUrl;
            this.scope = scope;
            this.score = score;
            this.title = title;
            this.userEnteredSubject = userEnteredSubject;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<String> getComments() {
            return comments;
        }

        public void setComments(List<String> comments) {
            this.comments = comments;
        }

        public boolean isCommentClosed() {
            return commentClosed;
        }

        public void setCommentClosed(boolean commentClosed) {
            this.commentClosed = commentClosed;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public long getCreationDateEpochSeconds() {
            return creationDateEpochSeconds;
        }

        public void setCreationDateEpochSeconds(long creationDateEpochSeconds) {
            this.creationDateEpochSeconds = creationDateEpochSeconds;
        }

        public int getDownvoteCount() {
            return downvoteCount;
        }

        public void setDownvoteCount(int downvoteCount) {
            this.downvoteCount = downvoteCount;
        }

        public String getEmbedUrl() {
            return embedUrl;
        }

        public void setEmbedUrl(String embedUrl) {
            this.embedUrl = embedUrl;
        }

        public boolean isHasGeoTag() {
            return hasGeoTag;
        }

        public void setHasGeoTag(boolean hasGeoTag) {
            this.hasGeoTag = hasGeoTag;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isInPopularPostsCuration() {
            return inPopularPostsCuration;
        }

        public void setInPopularPostsCuration(boolean inPopularPostsCuration) {
            this.inPopularPostsCuration = inPopularPostsCuration;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getMedia() {
            return media;
        }

        public void setMedia(List<String> media) {
            this.media = media;
        }

        public String getPublicPostUrl() {
            return publicPostUrl;
        }

        public void setPublicPostUrl(String publicPostUrl) {
            this.publicPostUrl = publicPostUrl;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isUserEnteredSubject() {
            return userEnteredSubject;
        }

        public void setUserEnteredSubject(boolean userEnteredSubject) {
            this.userEnteredSubject = userEnteredSubject;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "author=" + author +
                    ", body='" + body + '\'' +
                    ", category='" + category + '\'' +
                    ", comments=" + comments +
                    ", commentClosed=" + commentClosed +
                    ", commentCount=" + commentCount +
                    ", creationDateEpochSeconds=" + creationDateEpochSeconds +
                    ", downvoteCount=" + downvoteCount +
                    ", embedUrl='" + embedUrl + '\'' +
                    ", hasGeoTag=" + hasGeoTag +
                    ", id='" + id + '\'' +
                    ", inPopularPostsCuration=" + inPopularPostsCuration +
                    ", latitude=" + latitude +
                    ", likeCount=" + likeCount +
                    ", longitude=" + longitude +
                    ", url='" + url + '\'' +
                    ", media=" + media +
                    ", publicPostUrl='" + publicPostUrl + '\'' +
                    ", scope='" + scope + '\'' +
                    ", score=" + score +
                    ", title='" + title + '\'' +
                    ", userEnteredSubject=" + userEnteredSubject +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PostArea {
        @JsonProperty("centroid")
        private double[] centroid;

        @JsonProperty("area_sqft")
        private double areaSqft;

        public PostArea() {

        }

        public PostArea(double[] centroid, double areaSqft) {
            this.centroid = centroid;
            this.areaSqft = areaSqft;
        }

        public double[] getCentroid() {
            return centroid;
        }

        public void setCentroid(double[] centroid) {
            this.centroid = centroid;
        }

        public double getAreaSqft() {
            return areaSqft;
        }

        public void setAreaSqft(double areaSqft) {
            this.areaSqft = areaSqft;
        }

        @Override
        public String toString() {
            return "PostArea{" +
                    "centroid=" + Arrays.toString(centroid) +
                    ", areaSqft=" + areaSqft +
                    '}';
        }
    }
}
