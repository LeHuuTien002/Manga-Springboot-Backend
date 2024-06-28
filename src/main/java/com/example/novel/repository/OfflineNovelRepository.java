package com.example.novel.repository;

import com.example.novel.entity.OfflineNovel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfflineNovelRepository extends JpaRepository<OfflineNovel, Long> {
    List<OfflineNovel> findByUserId(Long userId);
}
