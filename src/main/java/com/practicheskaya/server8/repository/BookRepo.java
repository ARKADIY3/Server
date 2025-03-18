package com.practicheskaya.server8.repository;

import com.practicheskaya.server8.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
