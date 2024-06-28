package com.example.novel.repository;

import com.example.novel.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long userId);
    Favorite findByUserIdAndNovelId(Long userId, Long novelId);
}