package com.nextdoor.models.displayingcontent.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.Author;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPost extends NextDoorModel implements Serializable {
    @JsonProperty("postsLength")
    private int postsLength;

    @JsonProperty("posts")
    private List<Data> posts;

    public SearchPost() {

    }

    public SearchPost(int postsLength, List<Data> posts) {
        this.postsLength = postsLength;
        this.posts = posts;
    }

    public int getPostsLength() {
        return postsLength;
    }

    public void setPostsLength(int postsLength) {
        this.postsLength = postsLength;
    }

    public List<Data> getPosts() {
        return posts;
    }

    public void setPosts(List<Data> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "SearchPost{" +
                "postsLength=" + postsLength +
                ", posts=" + posts +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data implements Serializable {
        @JsonProperty("commentClosed")
        private boolean commentClosed;

        @JsonProperty("hasGeoTag")
        private boolean hasGeoTag;

        @JsonProperty("userEnteredSubject")
        private boolean userEnteredSubject;

        @JsonProperty("commentCount")
        private int commentCount;

        @JsonProperty("downvoteCount")
        private int downvoteCount;

        @JsonProperty("likeCount")
        private int likeCount;

        @JsonProperty("reportCount")
        private int reportCount;

        @JsonProperty("score")
        private int score;

        @JsonProperty("creationDateEpochSeconds")
        private long creationDateEpochSeconds;

        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("longitude")
        private double longitude;

        @JsonProperty("author")
        private Author author;

        @JsonProperty("body")
        private String body;

        @JsonProperty("category")
        private String category;

        @JsonProperty("embedUrl")
        private String embedUrl;

        @JsonProperty("id")
        private String id;

        @JsonProperty("publicPostUrl")
        private String publicPostUrl;

        @JsonProperty("scope")
        private String scope;

        @JsonProperty("title")
        private String title;

        @JsonProperty("url")
        private String url;

        @JsonProperty("videoPreviewUrl")
        private String videoPreviewUrl;

        @JsonProperty("comments")
        private List<String> comments;

        @JsonProperty("media")
        private List<String> media;

        @JsonProperty("mediaFocalArea")
        private List<Object> mediaFocalArea;

        @JsonProperty("reactionTypes")
        private Map<String, Integer> reactionTypes;

        @JsonProperty("scores")
        private List<Object> scores;

        public Data() {

        }

        public Data(boolean commentClosed, boolean hasGeoTag, boolean userEnteredSubject, int commentCount, int downvoteCount, int likeCount, int reportCount, int score, long creationDateEpochSeconds, double latitude, double longitude, Author author, String body, String category, String embedUrl, String id, String publicPostUrl, String scope, String title, String url, String videoPreviewUrl, List<String> comments, List<String> media, List<Object> mediaFocalArea, Map<String, Integer> reactionTypes, List<Object> scores) {
            this.commentClosed = commentClosed;
            this.hasGeoTag = hasGeoTag;
            this.userEnteredSubject = userEnteredSubject;
            this.commentCount = commentCount;
            this.downvoteCount = downvoteCount;
            this.likeCount = likeCount;
            this.reportCount = reportCount;
            this.score = score;
            this.creationDateEpochSeconds = creationDateEpochSeconds;
            this.latitude = latitude;
            this.longitude = longitude;
            this.author = author;
            this.body = body;
            this.category = category;
            this.embedUrl = embedUrl;
            this.id = id;
            this.publicPostUrl = publicPostUrl;
            this.scope = scope;
            this.title = title;
            this.url = url;
            this.videoPreviewUrl = videoPreviewUrl;
            this.comments = comments;
            this.media = media;
            this.mediaFocalArea = mediaFocalArea;
            this.reactionTypes = reactionTypes;
            this.scores = scores;
        }

        public boolean isCommentClosed() {
            return commentClosed;
        }

        public void setCommentClosed(boolean commentClosed) {
            this.commentClosed = commentClosed;
        }

        public boolean isHasGeoTag() {
            return hasGeoTag;
        }

        public void setHasGeoTag(boolean hasGeoTag) {
            this.hasGeoTag = hasGeoTag;
        }

        public boolean isUserEnteredSubject() {
            return userEnteredSubject;
        }

        public void setUserEnteredSubject(boolean userEnteredSubject) {
            this.userEnteredSubject = userEnteredSubject;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getDownvoteCount() {
            return downvoteCount;
        }

        public void setDownvoteCount(int downvoteCount) {
            this.downvoteCount = downvoteCount;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getReportCount() {
            return reportCount;
        }

        public void setReportCount(int reportCount) {
            this.reportCount = reportCount;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public long getCreationDateEpochSeconds() {
            return creationDateEpochSeconds;
        }

        public void setCreationDateEpochSeconds(long creationDateEpochSeconds) {
            this.creationDateEpochSeconds = creationDateEpochSeconds;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
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

        public String getEmbedUrl() {
            return embedUrl;
        }

        public void setEmbedUrl(String embedUrl) {
            this.embedUrl = embedUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVideoPreviewUrl() {
            return videoPreviewUrl;
        }

        public void setVideoPreviewUrl(String videoPreviewUrl) {
            this.videoPreviewUrl = videoPreviewUrl;
        }

        public List<String> getComments() {
            return comments;
        }

        public void setComments(List<String> comments) {
            this.comments = comments;
        }

        public List<String> getMedia() {
            return media;
        }

        public void setMedia(List<String> media) {
            this.media = media;
        }

        public List<Object> getMediaFocalArea() {
            return mediaFocalArea;
        }

        public void setMediaFocalArea(List<Object> mediaFocalArea) {
            this.mediaFocalArea = mediaFocalArea;
        }

        public Map<String, Integer> getReactionTypes() {
            return reactionTypes;
        }

        public void setReactionTypes(Map<String, Integer> reactionTypes) {
            this.reactionTypes = reactionTypes;
        }

        public List<Object> getScores() {
            return scores;
        }

        public void setScores(List<Object> scores) {
            this.scores = scores;
        }

        @Override
        public String toString() {
            return "SearchPostData{" +
                    "commentClosed=" + commentClosed +
                    ", hasGeoTag=" + hasGeoTag +
                    ", userEnteredSubject=" + userEnteredSubject +
                    ", commentCount=" + commentCount +
                    ", downvoteCount=" + downvoteCount +
                    ", likeCount=" + likeCount +
                    ", reportCount=" + reportCount +
                    ", score=" + score +
                    ", creationDateEpochSeconds=" + creationDateEpochSeconds +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", author=" + author +
                    ", body='" + body + '\'' +
                    ", category='" + category + '\'' +
                    ", embedUrl='" + embedUrl + '\'' +
                    ", id='" + id + '\'' +
                    ", publicPostUrl='" + publicPostUrl + '\'' +
                    ", scope='" + scope + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", videoPreviewUrl='" + videoPreviewUrl + '\'' +
                    ", comments=" + comments +
                    ", media=" + media +
                    ", mediaFocalArea=" + mediaFocalArea +
                    ", reactionTypes=" + reactionTypes +
                    ", scores=" + scores +
                    '}';
        }
    }
}