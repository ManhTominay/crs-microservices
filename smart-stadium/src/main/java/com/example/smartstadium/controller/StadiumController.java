package com.example.smartstadium.controller;

import com.example.smartstadium.entity.Field;
import com.example.smartstadium.entity.Stadium;
import com.example.smartstadium.repository.FieldRepository;
import com.example.smartstadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stadiums")
@RequiredArgsConstructor
public class StadiumController {

    private final StadiumRepository stadiumRepository;
    private final FieldRepository fieldRepository;

    // 1. Thêm mới một cơ sở sân
    @PostMapping
    public ResponseEntity<Stadium> createStadium(@RequestBody Stadium stadium) {
        return ResponseEntity.ok(stadiumRepository.save(stadium));
    }

    // 2. Lấy danh sách tất cả các sân
    @GetMapping
    public ResponseEntity<List<Stadium>> getAllStadiums() {
        return ResponseEntity.ok(stadiumRepository.findAll());
    }

    // 3. Thêm sân con (Field) vào cụm sân
    @PostMapping("/{stadiumId}/fields")
    public ResponseEntity<Field> addFieldToStadium(@PathVariable Long stadiumId, @RequestBody Field field) {
        Stadium stadium = stadiumRepository.findById(stadiumId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cụm sân"));
        field.setStadium(stadium);
        return ResponseEntity.ok(fieldRepository.save(field));
    }

    // 4. Xem danh sách sân con của một cụm sân
    @GetMapping("/{stadiumId}/fields")
    public ResponseEntity<List<Field>> getFieldsByStadium(@PathVariable Long stadiumId) {
        return ResponseEntity.ok(fieldRepository.findByStadiumId(stadiumId));
    }
}
