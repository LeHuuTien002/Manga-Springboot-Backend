package com.example.novel.service;

import com.example.novel.entity.OfflineNovel;
import com.example.novel.repository.OfflineNovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfflineNovelService {
    @Autowired
    private OfflineNovelRepository offlineNovelRepository;

    public List<OfflineNovel> findOfflineNovelsByUserId(Long userId) {
        return offlineNovelRepository.findByUserId(userId);
    }

    public OfflineNovel saveOfflineNovel(Long userId, Long novelId) {
        OfflineNovel offlineNovel = new OfflineNovel();
        offlineNovel.setUserId(userId);
        offlineNovel.setNovelId(novelId);
        offlineNovel.setDownloadedAt(LocalDateTime.now());
        return offlineNovelRepository.save(offlineNovel);
    }

    public void deleteOfflineNovel(Long offlineNovelId) {
        offlineNovelRepository.deleteById(offlineNovelId);
    }
}
