package com.example.novel.controller;


import com.example.novel.entity.Favorite;
import com.example.novel.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    // Endpoint để lấy danh sách truyện yêu thích của một người dùng
    @GetMapping("/{userId}")
    public List<Favorite> getUserFavorites(@PathVariable Long userId) {
        return favoriteService.findFavoritesByUserId(userId);
    }

    // Endpoint để đánh dấu một cuốn truyện là yêu thích của người dùng
    @PostMapping("/add")
    public void addFavorite(@RequestParam Long userId, @RequestParam Long novelId) {
        favoriteService.addFavorite(userId, novelId);
    }

    // Endpoint để hủy đánh dấu một cuốn truyện là yêu thích của người dùng
    @PostMapping("/remove")
    public void removeFavorite(@RequestParam Long userId, @RequestParam Long novelId) {
        favoriteService.removeFavorite(userId, novelId);
    }
}
