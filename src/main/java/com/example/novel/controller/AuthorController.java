package com.example.novel.controller;

import com.example.novel.entity.Author;
import com.example.novel.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    // Endpoint để lấy danh sách tất cả các tác giả
    @GetMapping
    public List<Author> getAllAuthors() {
        System.out.println(authorService.getAllAuthors());
        return authorService.getAllAuthors();
    }

    // Endpoint để lấy thông tin của một tác giả theo ID
    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    // Endpoint để tạo hoặc cập nhật thông tin của một tác giả
    @PostMapping("/save")
    public Author createOrUpdateAuthor(@RequestBody Author author) {
        return authorService.createOrUpdateAuthor(author);
    }

    // Endpoint để xóa thông tin của một tác giả
    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
