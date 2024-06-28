package com.example.novel.controller;

import com.example.novel.entity.Novel;
import com.example.novel.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/novels")
public class NovelController {
    @Autowired
    private NovelService novelService;

    // Endpoint để gợi ý các truyện theo thể loại
    @GetMapping("/genre/{genre}")
    public List<Novel> getNovelsByGenre(@PathVariable String genre) {
        return novelService.findNovelsByGenre(genre);
    }

    // Endpoint để gợi ý các truyện theo đánh giá
    @GetMapping("/rating/{rating}")
    public List<Novel> getNovelsByRating(@PathVariable double rating) {
        return novelService.findNovelsByRating(rating);
    }

    // Endpoint để lấy top 5 truyện có lượt xem cao nhất
    @GetMapping("/top-rated")
    public List<Novel> getTopRatedNovels() {
        return novelService.getTopRatedNovels();
    }
}