package com.example.exploreuttarakhand.controller;

import com.example.exploreuttarakhand.entity.Place;
import com.example.exploreuttarakhand.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        return placeService.getPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public List<Place> getPlacesByCategory(@PathVariable Place.Category category) {
        return placeService.getPlacesByCategory(category);
    }

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return placeService.savePlace(place);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place place) {
        if (!placeService.getPlaceById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        place.setId(id);
        return ResponseEntity.ok(placeService.savePlace(place));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        if (!placeService.getPlaceById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}