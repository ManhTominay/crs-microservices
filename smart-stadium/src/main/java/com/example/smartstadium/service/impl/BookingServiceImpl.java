package com.example.smartstadium.service.impl;

import com.example.smartstadium.entity.Booking;
import com.example.smartstadium.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public Booking createBooking(Long userId, Long fieldId, LocalDate date, LocalTime start, LocalTime end) {
        // Viết logic tạo booking ở đây
        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        // Viết logic lấy danh sách booking ở đây
        return List.of();
    }

    @Override
    public Booking getBookingById(Long id) {
        // Viết logic lấy booking theo id ở đây
        return null;
    }

    @Override
    public void cancelBooking(Long id) {
        // Viết logic hủy booking ở đây
    }
}