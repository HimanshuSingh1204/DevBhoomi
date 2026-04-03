package com.example.exploreuttarakhand.controller;

import com.example.exploreuttarakhand.entity.Place;
import com.example.exploreuttarakhand.entity.TravelPackage;
import com.example.exploreuttarakhand.entity.User;
import com.example.exploreuttarakhand.service.PlaceService;
import com.example.exploreuttarakhand.service.TravelPackageService;
import com.example.exploreuttarakhand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private TravelPackageService travelPackageService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/places")
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @PostMapping("/places")
    public Place createPlace(@RequestBody Place place) {
        return placeService.savePlace(place);
    }

    @GetMapping("/packages")
    public List<TravelPackage> getAllPackages() {
        return travelPackageService.getAllPackages();
    }

    @PostMapping("/packages")
    public TravelPackage createPackage(@RequestBody TravelPackage travelPackage) {
        return travelPackageService.savePackage(travelPackage);
    }
}