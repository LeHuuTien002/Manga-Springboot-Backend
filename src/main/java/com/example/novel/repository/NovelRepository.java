package com.example.novel.repository;

import com.example.novel.entity.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovelRepository extends JpaRepository<Novel, Long> {
    List<Novel> findByGenre(String genre); // Tìm kiếm theo thể loại

    List<Novel> findByRatingGreaterThanEqual(double rating); // Tìm kiếm theo đánh giá

    List<Novel> findTop5ByOrderByViewsDesc(); // Lấy 5 truyện có lượt xem cao nhất
}