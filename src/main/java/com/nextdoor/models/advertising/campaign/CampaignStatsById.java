package com.nextdoor.models.advertising.campaign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignStatsById extends NextDoorModel implements Serializable {

}