package com.practicheskaya.server8.repository;

import com.practicheskaya.server8.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author , Long> {

}
