package com.example.smartstadium.repository;

import com.example.smartstadium.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {

    // Khai báo hàm này để xử lý lỗi "Cannot resolve method 'findByStadiumId(Long)'" ở dòng 45
    List<Field> findByStadiumId(Long stadiumId);
}