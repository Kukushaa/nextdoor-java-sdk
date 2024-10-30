package com.nextdoor.models.advertising.ad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdStats extends NextDoorModel implements Serializable {

}