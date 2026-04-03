package com.example.exploreuttarakhand.controller;

import com.example.exploreuttarakhand.entity.TravelPackage;
import com.example.exploreuttarakhand.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService travelPackageService;

    @GetMapping
    public List<TravelPackage> getAllPackages() {
        return travelPackageService.getAllPackages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPackage> getPackageById(@PathVariable Long id) {
        return travelPackageService.getPackageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TravelPackage createPackage(@RequestBody TravelPackage travelPackage) {
        return travelPackageService.savePackage(travelPackage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TravelPackage> updatePackage(@PathVariable Long id, @RequestBody TravelPackage travelPackage) {
        if (!travelPackageService.getPackageById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        travelPackage.setId(id);
        return ResponseEntity.ok(travelPackageService.savePackage(travelPackage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        if (!travelPackageService.getPackageById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        travelPackageService.deletePackage(id);
        return ResponseEntity.noContent().build();
    }
}