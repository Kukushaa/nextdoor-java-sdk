package com.nextdoor.models.sharingcontent.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.api.sharingcontent.NextDoorAPIComments;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment extends NextDoorAPIRequestNode implements Serializable {
    @JsonProperty("id")
    private long id;

    @JsonProperty("body")
    private String body;

    @JsonProperty("creation_date_epoch_seconds")
    private long creationDateEpochSeconds;

    @JsonProperty("parent_comment_id")
    private long parentCommentId;

    public Comment() {
    }

    public Comment(long id, String body, long creationDateEpochSeconds, long parentCommentId) {
        this.id = id;
        this.body = body;
        this.creationDateEpochSeconds = creationDateEpochSeconds;
        this.parentCommentId = parentCommentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getCreationDateEpochSeconds() {
        return creationDateEpochSeconds;
    }

    public void setCreationDateEpochSeconds(long creationDateEpochSeconds) {
        this.creationDateEpochSeconds = creationDateEpochSeconds;
    }

    public long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", creationDateEpochSeconds=" + creationDateEpochSeconds +
                ", parentCommentId=" + parentCommentId +
                '}';
    }

    public static NextDoorAPIComments.NextDoorAPIEditComment editComment(String commentId, NextDoorAPIAuth nextDoorAPIAuth) {
        NextDoorUtil.ensureStringNotNull(commentId, "commentId");

        Comment comment = new Comment();
        comment.setId(Long.parseLong(commentId));
        comment.setNextDoorAPIAuth(nextDoorAPIAuth);
        return new NextDoorAPIComments.NextDoorAPIEditComment(comment);
    }

    public static NextDoorAPIComments.NextDoorAPIDeleteComment deleteComment(String commentId, NextDoorAPIAuth nextDoorAPIAuth) {
        NextDoorUtil.ensureStringNotNull(commentId, "commentId");

        Comment comment = new Comment();
        comment.setId(Long.parseLong(commentId));
        comment.setNextDoorAPIAuth(nextDoorAPIAuth);
        return new NextDoorAPIComments.NextDoorAPIDeleteComment(comment);
    }
}