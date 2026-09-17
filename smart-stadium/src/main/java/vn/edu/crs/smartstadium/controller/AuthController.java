package vn.edu.crs.smartstadium.controller;

import vn.edu.crs.smartstadium.entity.User;
import vn.edu.crs.smartstadium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    // API đăng ký người dùng mới
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Tên đăng nhập đã tồn tại!");
        }
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}