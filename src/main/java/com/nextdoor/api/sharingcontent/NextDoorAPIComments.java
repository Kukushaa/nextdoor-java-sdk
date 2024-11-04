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
package com.nextdoor.api.sharingcontent;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.sharingcontent.comment.Comment;
import com.nextdoor.models.sharingcontent.comment.CommentToPostOrReplyToComment;
import com.nextdoor.models.sharingcontent.comment.EditedComment;
import com.nextdoor.models.sharingcontent.deleted.DeletedModel;
import com.nextdoor.models.sharingcontent.post.PostsData;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.util.Collection;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL;

public class NextDoorAPIComments extends NextDoorAPIRequestNode {
    private static final String COMMENT_PREFIX = "comment/";

    public NextDoorAPIComments() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIComments(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICommentToPostOrReplyToComment commentToPostOrReplyToComment() {
        return new NextDoorAPICommentToPostOrReplyToComment(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPICommentToPostOrReplyToComment extends NextDoorAPIRequest<CommentToPostOrReplyToComment> implements NextDoorAPIExecute<CommentToPostOrReplyToComment> {
        public NextDoorAPICommentToPostOrReplyToComment(NextDoorAPIAuth nextDoorAPIAuth) {
            super(CommentToPostOrReplyToComment.class, nextDoorAPIAuth);
        }

        public NextDoorAPICommentToPostOrReplyToComment setPostOrCommentID(String postOrCommentID) {
            this.setParamInternal("id", postOrCommentID);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setMediaAttachments(Collection<String> mediaAttachments) {
            this.setParamInternal("media_attachments", mediaAttachments);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setParentCommentID(String parentCommentID) {
            this.setParamInternal("parent_comment_id", parentCommentID);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public CommentToPostOrReplyToComment execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new CommentToAPostOrReplyToACommentExcepton("Cannot reply to a comment or create comment to Post, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + COMMENT_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("id"), "id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }

        public static class CommentToAPostOrReplyToACommentExcepton extends APIRequestException {
            public CommentToAPostOrReplyToACommentExcepton() {
            }

            public CommentToAPostOrReplyToACommentExcepton(String s) {
                super(s);
            }

            public CommentToAPostOrReplyToACommentExcepton(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CommentToAPostOrReplyToACommentExcepton(Throwable throwable) {
                super(throwable);
            }

            public CommentToAPostOrReplyToACommentExcepton(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIEditComment extends NextDoorAPIRequest<EditedComment> implements NextDoorAPIExecute<EditedComment> {
        public NextDoorAPIEditComment(Comment comment) {
            super(EditedComment.class, comment.getNextDoorAPIAuth());

            this.setParamInternal("id", comment.getId());
        }

        public NextDoorAPIEditComment setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIEditComment setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public EditedComment execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.PUT, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CommentEditException("Cannot edit comment, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + COMMENT_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }

        public static class CommentEditException extends APIRequestException {
            public CommentEditException() {
            }

            public CommentEditException(String s) {
                super(s);
            }

            public CommentEditException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CommentEditException(Throwable throwable) {
                super(throwable);
            }

            public CommentEditException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDeleteComment extends NextDoorAPIRequest<DeletedModel> implements NextDoorAPIExecute<DeletedModel> {
        private final Comment comment;

        public NextDoorAPIDeleteComment(Comment comment) {
            super(DeletedModel.class, comment.getNextDoorAPIAuth());

            this.comment = comment;
        }

        public NextDoorAPIDeleteComment setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public DeletedModel execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.DELETE, getPath() + "?id=" + this.comment.getId());
            } catch (APIRequestException e) {
                throw new NextDoorAPIPosts.PostDeleteException("Cannot delete comment, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + COMMENT_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("secure_profile_id"), "secure_profile_id");
        }
    }
}
