package com.example.smartstadium.controller;

import com.example.smartstadium.entity.Booking;
import com.example.smartstadium.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestParam Long userId,
                                           @RequestParam Long fieldId,
                                           @RequestParam LocalDate date,
                                           @RequestParam LocalTime startTime,
                                           @RequestParam LocalTime endTime) {
        try {
            Booking booking = bookingService.createBooking(userId, fieldId, date, startTime, endTime);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
