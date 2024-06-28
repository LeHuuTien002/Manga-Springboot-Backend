package com.example.novel.controller;

import com.example.novel.entity.Rating;
import com.example.novel.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    // Endpoint để thêm hoặc cập nhật đánh giá cho một cuốn truyện
    @PostMapping("/add")
    public void addRating(@RequestParam Long userId, @RequestParam Long novelId, @RequestParam int stars) {
        ratingService.addRating(userId, novelId, stars);
    }

    // Endpoint để lấy đánh giá của một người dùng cho một cuốn truyện
    @GetMapping("/{userId}/{novelId}")
    public Rating getRatingByUserIdAndNovelId(@PathVariable Long userId, @PathVariable Long novelId) {
        return ratingService.getRatingByUserIdAndNovelId(userId, novelId);
    }
}
