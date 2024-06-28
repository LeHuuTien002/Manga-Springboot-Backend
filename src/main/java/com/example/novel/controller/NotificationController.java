package com.example.novel.controller;

import com.example.novel.entity.Notification;
import com.example.novel.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    // Endpoint để lấy danh sách thông báo của một người dùng
    @GetMapping("/{userId}")
    public List<Notification> getNotificationsByUserId(@PathVariable Long userId) {
        return notificationService.findNotificationsByUserId(userId);
    }

    // Endpoint để tạo thông báo mới
    @PostMapping("/create")
    public Notification createNotification(@RequestParam String title, @RequestParam String content, @RequestParam Long userId) {
        return notificationService.createNotification(title, content, userId);
    }
}
