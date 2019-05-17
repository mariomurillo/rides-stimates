package com.rides.estimate.services;

import com.rides.estimate.model.Estimate;
import com.rides.estimate.model.Location;
import com.rides.estimate.model.Price;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RidesEstimateService {

    Mono<Estimate> getEstimates(Location origin, Location destination);
}
