package com.example.exploreuttarakhand.service;

import com.example.exploreuttarakhand.entity.Comment;
import com.example.exploreuttarakhand.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByVideoId(Long videoId) {
        return commentRepository.findByVideoId(videoId);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}