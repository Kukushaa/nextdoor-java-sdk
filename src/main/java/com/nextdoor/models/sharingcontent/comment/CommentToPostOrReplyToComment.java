package com.nextdoor.models.sharingcontent.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentToPostOrReplyToComment extends NextDoorModel implements Serializable {

}
