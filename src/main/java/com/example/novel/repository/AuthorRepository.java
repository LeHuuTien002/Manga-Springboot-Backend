package com.example.novel.repository;

import com.example.novel.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Các phương thức tùy theo nhu cầu
}
