package com.example.exploreuttarakhand.controller;

import com.example.exploreuttarakhand.entity.Comment;
import com.example.exploreuttarakhand.entity.Like;
import com.example.exploreuttarakhand.entity.Video;
import com.example.exploreuttarakhand.service.CloudinaryService;
import com.example.exploreuttarakhand.service.CommentService;
import com.example.exploreuttarakhand.service.LikeService;
import com.example.exploreuttarakhand.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadVideo(@RequestParam("file") MultipartFile file,
                                         @RequestParam("caption") String caption,
                                         @RequestParam("userId") Long userId) {
        try {
            String url = cloudinaryService.uploadFile(file);
            Video video = new Video();
            // Assume user is set, need to fetch user
            // video.setUser(userRepository.findById(userId).orElse(null));
            video.setUrl(url);
            video.setCaption(caption);
            Video savedVideo = videoService.saveVideo(video);
            return ResponseEntity.ok(savedVideo);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Upload failed");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        if (!videoService.getVideoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{videoId}/like")
    public ResponseEntity<?> likeVideo(@PathVariable Long videoId, @RequestParam Long userId) {
        if (likeService.getLikeByUserAndVideo(userId, videoId).isPresent()) {
            return ResponseEntity.badRequest().body("Already liked");
        }
        Like like = new Like();
        // Set user and video
        likeService.saveLike(like);
        return ResponseEntity.ok("Liked");
    }

    @DeleteMapping("/{videoId}/like")
    public ResponseEntity<Void> unlikeVideo(@PathVariable Long videoId, @RequestParam Long userId) {
        likeService.getLikeByUserAndVideo(userId, videoId).ifPresent(like -> likeService.deleteLike(like.getId()));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{videoId}/comments")
    public List<Comment> getComments(@PathVariable Long videoId) {
        return commentService.getCommentsByVideoId(videoId);
    }

    @PostMapping("/{videoId}/comments")
    public Comment addComment(@PathVariable Long videoId, @RequestBody Comment comment) {
        // Set video
        return commentService.saveComment(comment);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}