package com.example.exploreuttarakhand.controller;

import com.example.exploreuttarakhand.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public Map<String, Object> getRoute(@RequestParam double originLat, @RequestParam double originLng,
                                        @RequestParam double destLat, @RequestParam double destLng) {
        return routeService.getRoute(originLat, originLng, destLat, destLng);
    }
}