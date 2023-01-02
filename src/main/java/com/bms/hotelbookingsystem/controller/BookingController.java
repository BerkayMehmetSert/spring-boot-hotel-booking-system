package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.BookingDto;
import com.bms.hotelbookingsystem.dto.request.CreateBookingRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateBookingRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@Slf4j
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Void> createBooking(@RequestBody CreateBookingRequest request) {
        bookingService.createBooking(request);

        log.info(ControllerLogMessage.Booking.BOOKING_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBooking(@PathVariable String id, @RequestBody UpdateBookingRequest request) {
        bookingService.updateBooking(id, request);

        log.info(ControllerLogMessage.Booking.BOOKING_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
        bookingService.deleteBooking(id);

        log.info(ControllerLogMessage.Booking.BOOKING_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> findBookingById(@PathVariable String id) {
        BookingDto bookingDto = bookingService.findBookingById(id);

        log.info(ControllerLogMessage.Booking.BOOKING_FOUND + id);
        return ResponseEntity.ok(bookingDto);
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> findAllBookings() {
        List<BookingDto> bookingDtoList = bookingService.findAllBookings();

        log.info(ControllerLogMessage.Booking.BOOKING_LISTED);
        return ResponseEntity.ok(bookingDtoList);
    }
}
