package com.example.novel.service;

import com.example.novel.entity.Comment;
import com.example.novel.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findCommentsByNovelId(Long novelId) {
        return commentRepository.findByNovelId(novelId);
    }

    public void addComment(Long userId, Long novelId, String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setNovelId(novelId);
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);
    }
}