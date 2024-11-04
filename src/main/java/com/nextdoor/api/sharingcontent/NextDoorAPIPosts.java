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
import com.nextdoor.models.*;
import com.nextdoor.models.sharingcontent.agency.AgencyBoundaries;
import com.nextdoor.models.sharingcontent.agency.AgencyNeighborhoodBoundaries;
import com.nextdoor.models.sharingcontent.deleted.DeletedModel;
import com.nextdoor.models.sharingcontent.post.ExistedPost;
import com.nextdoor.models.sharingcontent.post.Post;
import com.nextdoor.models.sharingcontent.post.PostsData;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.share.interfaces.NextDoorAPIExecuteList;
import com.nextdoor.util.NextDoorUtil;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL;

public class NextDoorAPIPosts extends NextDoorAPIRequestNode {
    private static final String POST_PREFIX = "post";

    public NextDoorAPIPosts() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIPosts(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateDefaultPost createDefaultPost() {
        return new NextDoorAPICreateDefaultPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPICreateAgencyPost createAgencyPost() {
        return new NextDoorAPICreateAgencyPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPICreateEventPost createEventPost() {
        return new NextDoorAPICreateEventPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPICreateFSFPost createFSFPost() {
        return new NextDoorAPICreateFSFPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIGetAllPosts getAllPosts() {
        return new NextDoorAPIGetAllPosts(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIGetAgencyBoundaries getAgencyBoundaries() {
        return new NextDoorAPIGetAgencyBoundaries(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPIGetAllPosts extends NextDoorAPIRequest<PostsData> implements NextDoorAPIExecute<PostsData> {
        public NextDoorAPIGetAllPosts(NextDoorAPIAuth nextDoorAPIAuth) {
            super(PostsData.class, nextDoorAPIAuth);
        }

        public NextDoorAPIGetAllPosts setSecureProfileID(String secureProfileID) {
            this.addHeader("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public PostsData execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new PostCreateException("Cannot get all posts, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {

        }
    }

    public static class NextDoorAPIGetAgencyBoundaries extends NextDoorAPIRequest<AgencyBoundaries> implements NextDoorAPIExecuteList<AgencyBoundaries> {
        public NextDoorAPIGetAgencyBoundaries(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AgencyBoundaries.class, nextDoorAPIAuth);
        }

        public NextDoorAPIGetAgencyBoundaries setParameterShowGeometries(Boolean showGeometries) {
            this.addParameters("show_geometries", showGeometries.toString());

            return this;
        }

        public NextDoorAPIGetAgencyBoundaries setParameterEnablePagination(Boolean enablePagination) {
            this.addParameters("enable_pagination", enablePagination.toString());

            return this;
        }

        public NextDoorAPIGetAgencyBoundaries setParameterAfter(String after) {
            this.addParameters("after", after);

            return this;
        }

        @Override
        public List<AgencyBoundaries> execute() throws APIRequestException {
            this.checkAndReplaceOrAddParameter("show_geometries", "true");
            this.checkAndReplaceOrAddParameter("enable_pagination", "true");

            try {
                return sendHttpRequestForList(HttpMethod.GET, getPath(), ConversionType.NONE);
            } catch (APIRequestException e) {
                throw new AgencyBoundariesGetException("Cannot get agency boundaries, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + "agency/boundary/";
        }

        @Override
        protected void validateRequiredParams() {

        }

        public static class AgencyBoundariesGetException extends APIRequestException {
            public AgencyBoundariesGetException() {
            }

            public AgencyBoundariesGetException(String s) {
                super(s);
            }

            public AgencyBoundariesGetException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AgencyBoundariesGetException(Throwable throwable) {
                super(throwable);
            }

            public AgencyBoundariesGetException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIGetAgencyNeighborhoodBoundaries extends NextDoorAPIRequest<AgencyNeighborhoodBoundaries> implements NextDoorAPIExecute<AgencyNeighborhoodBoundaries> {
        public NextDoorAPIGetAgencyNeighborhoodBoundaries(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AgencyNeighborhoodBoundaries.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + "agency/neighborhood_boundary/";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AgencyNeighborhoodBoundaries execute() throws APIRequestException {
            this.addParameters("show_geometries", "true");

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new GetAgencyNeighborhoodBoundaries("Cannot get agency neighborhood, because of: " + e.getLocalizedMessage());
            }
        }

        public static class GetAgencyNeighborhoodBoundaries extends APIRequestException {
            public GetAgencyNeighborhoodBoundaries() {
            }

            public GetAgencyNeighborhoodBoundaries(String s) {
                super(s);
            }

            public GetAgencyNeighborhoodBoundaries(String s, Throwable throwable) {
                super(s, throwable);
            }

            public GetAgencyNeighborhoodBoundaries(Throwable throwable) {
                super(throwable);
            }

            public GetAgencyNeighborhoodBoundaries(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPICreateDefaultPost extends NextDoorAPIRequest<Post> implements NextDoorAPIExecute<Post> {
        public NextDoorAPICreateDefaultPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateDefaultPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateDefaultPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPICreateDefaultPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to " + POST_PREFIX);
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPICreateDefaultPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to " + POST_PREFIX);

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPICreateDefaultPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPICreateDefaultPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPICreateDefaultPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        public NextDoorAPICreateDefaultPost setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public Post execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new PostCreationException("Cannot create default " + POST_PREFIX + " because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX + "/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }
    }

    public static class NextDoorAPICreateAgencyPost extends NextDoorAPIRequest<Post> implements NextDoorAPIExecute<Post> {
        public NextDoorAPICreateAgencyPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateAgencyPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateAgencyPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPICreateAgencyPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to " + POST_PREFIX);
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPICreateAgencyPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to " + POST_PREFIX);

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPICreateAgencyPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPICreateAgencyPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPICreateAgencyPost setRadius(String radius) {
            this.setParamInternal("radius", radius);

            return this;
        }

        public NextDoorAPICreateAgencyPost setGroupIDs(Collection<Integer> groupIDs) {
            if (groupIDs == null) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to " + POST_PREFIX);

                return this;
            }

            this.setParamInternal("group_ids", groupIDs);

            return this;
        }

        public NextDoorAPICreateAgencyPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        @Override
        public Post execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new PostCreationException("Cannot agency default " + POST_PREFIX + " because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX + "/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }
    }

    public static class NextDoorAPICreateEventPost extends NextDoorAPIRequest<Post> implements NextDoorAPIExecute<Post> {
        private static final String EVENT_NAME = "event";

        public NextDoorAPICreateEventPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateEventPost setEvent(Event event) {
            this.setParamInternal(EVENT_NAME, event);

            return this;
        }

        public NextDoorAPICreateEventPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateEventPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPICreateEventPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to " + POST_PREFIX);
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPICreateEventPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to " + POST_PREFIX);

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPICreateEventPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPICreateEventPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPICreateEventPost setRadius(String radius) {
            this.setParamInternal("radius", radius);

            return this;
        }

        public NextDoorAPICreateEventPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        @Override
        public Post execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, getPath() + "?" + EVENT_NAME + "=" + ((Event) this.getParamInternal(EVENT_NAME)).toUrlEncodedString());
            } catch (APIRequestException | IllegalAccessException | UnsupportedEncodingException e) {
                throw new PostCreationException("Cannot agency default " + POST_PREFIX + " because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX + "/" + EVENT_NAME + "/";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
            Event event = (Event) this.getParamInternal(EVENT_NAME);
            NextDoorUtil.ensureObjectNotNull(event, EVENT_NAME);

            NextDoorUtil.ensureStringNotNull(event.getTitle(), EVENT_NAME + ".title");
            NextDoorUtil.ensureStringNotNull(event.getDescription(), EVENT_NAME + ".description");
            NextDoorUtil.ensureObjectNotNull(event.getStartTime(), EVENT_NAME + ".startTime");
        }
    }

    public static class NextDoorAPICreateFSFPost extends NextDoorAPIRequest<Post> implements NextDoorAPIExecute<Post> {
        private static final String FSF_NAME = "fsf";

        public NextDoorAPICreateFSFPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateFSFPost setFSF(FSF fsf) {
            this.setParamInternal(FSF_NAME, fsf);

            return this;
        }

        public NextDoorAPICreateFSFPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateFSFPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPICreateFSFPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        @Override
        public Post execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, getPath() + "?" + FSF_NAME + "=" + ((FSF) this.getParamInternal(FSF_NAME)).toUrlEncodedString());
            } catch (APIRequestException | IllegalAccessException | UnsupportedEncodingException e) {
                throw new PostCreationException("Cannot agency default " + POST_PREFIX + " because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX + "/" + FSF_NAME + "/";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
            FSF fsf = (FSF) this.getParamInternal(FSF_NAME);
            NextDoorUtil.ensureObjectNotNull(fsf, FSF_NAME);

            NextDoorUtil.ensureStringNotNull(fsf.getTitle(), FSF_NAME + ".title");
            NextDoorUtil.ensureStringNotNull(fsf.getDescription(), FSF_NAME + ".description");
            NextDoorUtil.ensureStringNotNull(fsf.getPrice(), FSF_NAME + ".price");
            NextDoorUtil.ensureStringNotNull(fsf.getCategory(), FSF_NAME + ".category");

            Collection<String> imageAttachments = fsf.getImageAttachments();
            NextDoorUtil.ensureObjectNotNull(imageAttachments, FSF_NAME + ".image_attachments");
            if (imageAttachments.size() > 10) {
                throw new RuntimeException("Cannot attach attachments to " + POST_PREFIX + ", because there are more than 10 images");
            }
        }
    }

    public static class NextDoorAPIEditPost extends NextDoorAPIRequest<Post> implements NextDoorAPIExecute<Post> {
        public NextDoorAPIEditPost(ExistedPost existedPost) {
            super(Post.class, existedPost.getNextDoorAPIAuth());

            NextDoorUtil.ensureObjectNotNull(existedPost, "existedPost");
            String postId = existedPost.getId();
            NextDoorUtil.ensureStringNotNull(postId, "postId");
            this.setParamInternal("id", postId);
        }

        public NextDoorAPIEditPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIEditPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPIEditPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPIEditPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPIEditPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        public NextDoorAPIEditPost setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public Post execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new PostEditException("Cannot get all posts, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {

        }
    }

    public static class NextDoorAPIDeletePost extends NextDoorAPIRequest<DeletedModel> implements NextDoorAPIExecute<DeletedModel> {
        private ExistedPost existedPost;

        public NextDoorAPIDeletePost() {
            super(DeletedModel.class, NextDoorAPIAuth.defaultNextDoorAPIAuth());
        }

        public NextDoorAPIDeletePost(ExistedPost existedPost) {
            super(DeletedModel.class, existedPost.getNextDoorAPIAuth());

            this.existedPost = existedPost;
        }

        public NextDoorAPIDeletePost setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public DeletedModel execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.DELETE, getPath() + "?id=" + this.existedPost.getId());
            } catch (APIRequestException e) {
                throw new PostDeleteException("Cannot delete post, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("secure_profile_id"), "secure_profile_id");
        }
    }

    public static class PostDeleteException extends APIRequestException {
        public PostDeleteException() {
        }

        public PostDeleteException(String s) {
            super(s);
        }

        public PostDeleteException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public PostDeleteException(Throwable throwable) {
            super(throwable);
        }

        public PostDeleteException(String s, Throwable throwable, boolean b, boolean b1) {
            super(s, throwable, b, b1);
        }
    }

    public static class PostCreationException extends APIRequestException {
        public PostCreationException() {
        }

        public PostCreationException(String s) {
            super(s);
        }

        public PostCreationException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public PostCreationException(Throwable throwable) {
            super(throwable);
        }

        public PostCreationException(String s, Throwable throwable, boolean b, boolean b1) {
            super(s, throwable, b, b1);
        }
    }

    public static class PostEditException extends APIRequestException {
        public PostEditException() {
        }

        public PostEditException(String s) {
            super(s);
        }

        public PostEditException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public PostEditException(Throwable throwable) {
            super(throwable);
        }

        public PostEditException(String s, Throwable throwable, boolean b, boolean b1) {
            super(s, throwable, b, b1);
        }
    }

    public static class PostCreateException extends APIRequestException {
        public PostCreateException() {
        }

        public PostCreateException(String s) {
            super(s);
        }

        public PostCreateException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public PostCreateException(Throwable throwable) {
            super(throwable);
        }

        public PostCreateException(String s, Throwable throwable, boolean b, boolean b1) {
            super(s, throwable, b, b1);
        }
    }
}
