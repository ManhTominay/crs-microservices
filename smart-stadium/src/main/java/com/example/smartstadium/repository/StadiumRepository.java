package com.example.smartstadium.repository;

import com.example.smartstadium.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}