package com.example.novel.service;

import com.example.novel.entity.Rating;
import com.example.novel.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public void addRating(Long userId, Long novelId, int stars) {
        Rating rating = ratingRepository.findByUserIdAndNovelId(userId, novelId);
        if (rating == null) {
            rating = new Rating();
            rating.setUserId(userId);
            rating.setNovelId(novelId);
            rating.setStars(stars);
            ratingRepository.save(rating);
        } else {
            rating.setStars(stars);
            ratingRepository.save(rating);
        }
    }

    public Rating getRatingByUserIdAndNovelId(Long userId, Long novelId) {
        return ratingRepository.findByUserIdAndNovelId(userId, novelId);
    }
}
