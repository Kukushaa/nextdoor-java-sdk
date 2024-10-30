package com.nextdoor.models.displayingcontent.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPostsBySignals extends NextDoorModel implements Serializable {
    @JsonProperty("posts")
    private List<Data> posts;

    public SearchPostsBySignals() {

    }

    public SearchPostsBySignals(List<Data> posts) {
        this.posts = posts;
    }

    public List<Data> getPosts() {
        return posts;
    }

    public void setPosts(List<Data> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "SearchPostsBySignals{" +
                "posts=" + posts +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data implements Serializable {
        @JsonProperty("hasGeoTag")
        private boolean hasGeoTag;

        @JsonProperty("creationTimeUsec")
        private long creationTimeUsec;

        @JsonProperty("id")
        private String id;

        @JsonProperty("body")
        private String body;

        @JsonProperty("embedUrl")
        private String embedUrl;

        @JsonProperty("title")
        private String title;

        @JsonProperty("url")
        private String url;

        @JsonProperty("photoUrls")
        private List<String> photoUrls;

        public Data() {

        }

        public Data(boolean hasGeoTag, long creationTimeUsec, String id, String body, String embedUrl, String title, String url, List<String> photoUrls) {
            this.hasGeoTag = hasGeoTag;
            this.creationTimeUsec = creationTimeUsec;
            this.id = id;
            this.body = body;
            this.embedUrl = embedUrl;
            this.title = title;
            this.url = url;
            this.photoUrls = photoUrls;
        }

        public boolean isHasGeoTag() {
            return hasGeoTag;
        }

        public void setHasGeoTag(boolean hasGeoTag) {
            this.hasGeoTag = hasGeoTag;
        }

        public long getCreationTimeUsec() {
            return creationTimeUsec;
        }

        public void setCreationTimeUsec(long creationTimeUsec) {
            this.creationTimeUsec = creationTimeUsec;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getEmbedUrl() {
            return embedUrl;
        }

        public void setEmbedUrl(String embedUrl) {
            this.embedUrl = embedUrl;
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

        public List<String> getPhotoUrls() {
            return photoUrls;
        }

        public void setPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "hasGeoTag=" + hasGeoTag +
                    ", creationTimeUsec=" + creationTimeUsec +
                    ", id='" + id + '\'' +
                    ", body='" + body + '\'' +
                    ", embedUrl='" + embedUrl + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", photoUrls=" + photoUrls +
                    '}';
        }
    }
}
