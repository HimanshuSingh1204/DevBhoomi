package com.example.exploreuttarakhand.repository;

import com.example.exploreuttarakhand.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByVideoId(Long videoId);
    Optional<Like> findByUserIdAndVideoId(Long userId, Long videoId);
}