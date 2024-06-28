package com.example.novel.service;

import com.example.novel.entity.Novel;
import com.example.novel.repository.NovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovelService {
    @Autowired
    private NovelRepository novelRepository;

    public List<Novel> findNovelsByGenre(String genre) {
        return novelRepository.findByGenre(genre);
    }

    public List<Novel> findNovelsByRating(double rating) {
        return novelRepository.findByRatingGreaterThanEqual(rating);
    }

    public List<Novel> getTopRatedNovels() {
        return novelRepository.findTop5ByOrderByViewsDesc();
    }
}
