package com.rides.estimate.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Price implements Serializable {

    private String productId;

    private String currencyCode;

    private String displayName;

    private String localizedDisplayName;

    private String estimate;

    private Integer minimum;

    private Integer lowEstimate;

    private Integer highEstimate;

    private Float surgeMultiplier;

    private Integer duration;

    private Float distance;
}
