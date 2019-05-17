package com.rides.estimate.controllers;

import com.rides.estimate.model.Estimate;
import com.rides.estimate.model.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EstimateControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getEstimate() {

        webTestClient.get().uri("/api/rides/estimate/price?origin_latitude=4.635582&origin_longitude=-74.067879&" +
                "destination_latitude=4.629062&destination_longitude=-74.089555")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }
}
