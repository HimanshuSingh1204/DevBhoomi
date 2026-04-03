package com.example.exploreuttarakhand.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "places")
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(length = 1000)
    private String description;

    private Double lat;
    private Double lng;

    private Double cost;

    public enum Category {
        HIDDEN_GEMS, POPULAR_DESTINATIONS, SPIRITUAL_PLACES, HILL_STATIONS
    }
}