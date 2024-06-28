package com.example.novel.service;

import com.example.novel.entity.Favorite;
import com.example.novel.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> findFavoritesByUserId(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    public void addFavorite(Long userId, Long novelId) {
        Favorite favorite = favoriteRepository.findByUserIdAndNovelId(userId, novelId);
        if (favorite == null) {
            favorite = new Favorite();
            favorite.setUserId(userId);
            favorite.setNovelId(novelId);
            favoriteRepository.save(favorite);
        }
    }

    public void removeFavorite(Long userId, Long novelId) {
        Favorite favorite = favoriteRepository.findByUserIdAndNovelId(userId, novelId);
        if (favorite != null) {
            favoriteRepository.delete(favorite);
        }
    }
}