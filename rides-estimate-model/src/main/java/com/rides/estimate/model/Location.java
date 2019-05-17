package com.rides.estimate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Location {

    private final String latitude;

    private final String longitude;
}
