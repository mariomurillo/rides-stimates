package com.rides.estimate.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Estimate implements Serializable {

    private List<Price> prices;
}
