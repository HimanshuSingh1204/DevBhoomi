package com.example.exploreuttarakhand.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookmarks")
@Data
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;
}