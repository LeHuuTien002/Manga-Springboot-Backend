package com.example.novel.repository;

import com.example.novel.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating findByUserIdAndNovelId(Long userId, Long novelId);
}
