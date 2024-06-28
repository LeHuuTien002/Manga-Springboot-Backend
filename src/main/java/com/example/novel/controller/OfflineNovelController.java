package com.example.novel.controller;

import com.example.novel.entity.OfflineNovel;
import com.example.novel.service.OfflineNovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offline-novels")
public class OfflineNovelController {
    @Autowired
    private OfflineNovelService offlineNovelService;

    // Endpoint để lấy danh sách các truyện offline của một người dùng
    @GetMapping("/{userId}")
    public List<OfflineNovel> getOfflineNovelsByUserId(@PathVariable Long userId) {
        return offlineNovelService.findOfflineNovelsByUserId(userId);
    }

    // Endpoint để lưu truyện vào danh sách offline của người dùng
    @PostMapping("/save")
    public OfflineNovel saveOfflineNovel(@RequestParam Long userId, @RequestParam Long novelId) {
        return offlineNovelService.saveOfflineNovel(userId, novelId);
    }

    // Endpoint để xóa truyện khỏi danh sách offline của người dùng
    @DeleteMapping("/delete/{offlineNovelId}")
    public void deleteOfflineNovel(@PathVariable Long offlineNovelId) {
        offlineNovelService.deleteOfflineNovel(offlineNovelId);
    }
}
