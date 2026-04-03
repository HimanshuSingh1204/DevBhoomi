package com.example.exploreuttarakhand.service;

import com.example.exploreuttarakhand.entity.Like;
import com.example.exploreuttarakhand.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getLikesByVideoId(Long videoId) {
        return likeRepository.findByVideoId(videoId);
    }

    public Optional<Like> getLikeByUserAndVideo(Long userId, Long videoId) {
        return likeRepository.findByUserIdAndVideoId(userId, videoId);
    }

    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}