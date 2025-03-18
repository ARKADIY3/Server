package com.practicheskaya.server8.repository;

import com.practicheskaya.server8.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Long> {
}
