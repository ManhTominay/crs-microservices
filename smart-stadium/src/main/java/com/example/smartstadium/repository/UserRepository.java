package com.example.smartstadium.repository;

import com.example.smartstadium.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Thêm dòng này để Spring Data JPA tự động sinh câu lệnh SQL tìm User theo username
    Optional<User> findByUsername(String username);
}