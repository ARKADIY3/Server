package com.practicheskaya.server8.repository;

import com.practicheskaya.server8.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {
}
