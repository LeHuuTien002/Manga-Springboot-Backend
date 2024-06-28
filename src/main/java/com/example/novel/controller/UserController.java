package com.example.novel.controller;

import com.example.novel.entity.User;
import com.example.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder; // Autowire PasswordEncoder

    // Endpoint để đăng ký người dùng mới
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Endpoint để đăng nhập (có thể xử lý ở phần security của ứng dụng)
    @PostMapping("/login")
    public User loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.findByUsername(username);
        // Kiểm tra mật khẩu
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null; // Trả về null nếu đăng nhập không thành công
    }
}
