package com.example.exploreuttarakhand.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RouteService {

    @Value("${google.maps.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getRoute(double originLat, double originLng, double destLat, double destLng) {
        String url = String.format(
            "https://maps.googleapis.com/maps/api/directions/json?origin=%f,%f&destination=%f,%f&key=%s",
            originLat, originLng, destLat, destLng, apiKey
        );

        // In production, handle the response properly
        // For now, return mock data
        Map<String, Object> mockResponse = Map.of(
            "status", "OK",
            "routes", java.util.List.of(
                Map.of("summary", "Mock Route", "legs", java.util.List.of(
                    Map.of("distance", Map.of("text", "100 km"), "duration", Map.of("text", "2 hours"))
                ))
            )
        );
        return mockResponse;
    }
}