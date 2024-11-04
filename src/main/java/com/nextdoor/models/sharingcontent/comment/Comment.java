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
