package com.example.novel.controller;

import com.example.novel.entity.Comment;
import com.example.novel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // Endpoint để lấy danh sách bình luận của một cuốn truyện
    @GetMapping("/{novelId}")
    public List<Comment> getCommentsByNovelId(@PathVariable Long novelId) {
        return commentService.findCommentsByNovelId(novelId);
    }

    // Endpoint để thêm bình luận cho một cuốn truyện
    @PostMapping("/add")
    public void addComment(@RequestParam Long userId, @RequestParam Long novelId, @RequestParam String content) {
        commentService.addComment(userId, novelId, content);
    }
}
