package com.practicheskaya.server8.repository;

import com.practicheskaya.server8.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Long> {
}
