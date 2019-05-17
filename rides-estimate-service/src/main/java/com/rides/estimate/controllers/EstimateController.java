package com.rides.estimate.controllers;

import com.rides.estimate.model.Estimate;
import com.rides.estimate.model.Location;
import com.rides.estimate.model.Price;
import com.rides.estimate.services.RidesEstimateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping
public class EstimateController {

    private final RidesEstimateService ridesEstimateService;

    public EstimateController(final RidesEstimateService ridesEstimateService) {
        this.ridesEstimateService = ridesEstimateService;
    }

    @GetMapping("/price")
    public Mono<ResponseEntity<Estimate>> getEstimate(@RequestParam("origin_latitude") final String originLatitude,
                                                      @RequestParam("origin_longitude") final String originLongitude,
                                                      @RequestParam("destination_latitude") final String destinationLatitude,
                                                      @RequestParam("destination_longitude") final String destinationLongitude) {

        return ridesEstimateService.getEstimates(
                Location.builder().latitude(originLatitude).longitude(originLongitude).build(),
                Location.builder().latitude(destinationLatitude).longitude(destinationLongitude).build())
                .map(p -> ResponseEntity.ok(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
