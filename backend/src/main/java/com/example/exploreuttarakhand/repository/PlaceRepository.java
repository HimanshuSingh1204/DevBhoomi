package com.example.exploreuttarakhand.repository;

import com.example.exploreuttarakhand.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByCategory(Place.Category category);
}