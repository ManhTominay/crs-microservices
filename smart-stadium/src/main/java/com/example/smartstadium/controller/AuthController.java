package com.example.smartstadium.controller;

import com.example.smartstadium.entity.User;
import com.example.smartstadium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    // API Đăng ký
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Tên đăng nhập đã tồn tại!");
        }
        if (user.getRole() == null) {
            user.setRole(User.Role.CUSTOMER);
        }
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // API Đăng nhập (BỔ SUNG PHẦN NÀY)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginReq) {
        // Tìm user theo username
        Optional<User> userOptional = userRepository.findByUsername(loginReq.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Kiểm tra khớp mật khẩu
            if (user.getPassword().equals(loginReq.getPassword())) {
                return ResponseEntity.ok(user);
            }
        }

        return ResponseEntity.badRequest().body("Tài khoản hoặc mật khẩu không chính xác!");
    }
}