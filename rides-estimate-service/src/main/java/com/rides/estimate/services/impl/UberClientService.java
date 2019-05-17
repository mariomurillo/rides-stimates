package com.rides.estimate.services.impl;

import com.rides.estimate.model.Estimate;
import com.rides.estimate.model.Location;
import com.rides.estimate.services.RidesEstimateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class UberClientService implements RidesEstimateService {

    private final WebClient webClient;

    private final String uberApiPath;

    private final String aughorization;

    public UberClientService(final WebClient webClient, @Value("${uber.path}") final String uberApiPath,
                             @Value("${uber.authorization}") final String authorization) {
        this.webClient = webClient;
        this.uberApiPath = uberApiPath;
        this.aughorization = authorization;
    }

    @Override
    public Mono<Estimate> getEstimates(Location origin, Location destination) {

        return webClient.get().uri(getUrl(origin, destination))
                .header("Authorization", aughorization)
                //.header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve().bodyToMono(Estimate.class);
    }

    private String getUrl(Location origin, Location destination) {

        String url = uberApiPath.concat("?");

        url = Objects.nonNull(origin) ? url.concat("start_latitude=").concat(origin.getLatitude())
                .concat("&start_longitude=").concat(origin.getLongitude()).concat("&") : url;

        url = Objects.nonNull(destination) ? url.concat("end_latitude=").concat(destination.getLatitude())
                .concat("&end_longitude=").concat(destination.getLongitude()) : url;

        return url;
    }
}
