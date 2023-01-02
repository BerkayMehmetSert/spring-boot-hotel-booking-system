package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.BookingDateDto;
import com.bms.hotelbookingsystem.dto.request.CreateBookingDateRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateBookingDateRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.BookingDateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/booking-date")
@Slf4j
public class BookingDateController {
    private final BookingDateService bookingDateService;

    public BookingDateController(BookingDateService bookingDateService) {
        this.bookingDateService = bookingDateService;
    }

    @PostMapping
    public ResponseEntity<Void> createBookingDate(@RequestBody CreateBookingDateRequest request) {
        bookingDateService.createBookingDate(request);

        log.info(ControllerLogMessage.BookingDate.BOOKING_DATE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBookingDate(@PathVariable String id, @RequestBody UpdateBookingDateRequest request) {
        bookingDateService.updateBookingDate(id, request);

        log.info(ControllerLogMessage.BookingDate.BOOKING_DATE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/check-out-date")
    public ResponseEntity<Void> updateBookingDateCheckOutDate(@PathVariable String id,
                                                              @RequestParam LocalDate checkOutDate) {
        bookingDateService.updateBookingDateCheckOutDate(id, checkOutDate);

        log.info(ControllerLogMessage.BookingDate.BOOKING_DATE_CHECK_OUT_DATE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingDate(@PathVariable String id) {
        bookingDateService.deleteBookingDate(id);

        log.info(ControllerLogMessage.BookingDate.BOOKING_DATE_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDateDto> findBookingById(@PathVariable String id) {
        BookingDateDto bookingDateDto = bookingDateService.findBookingDateById(id);

        log.info(ControllerLogMessage.BookingDate.BOOKING_DATE_FOUND + id);
        return ResponseEntity.ok(bookingDateDto);
    }

    @GetMapping
    public ResponseEntity<List<BookingDateDto>> findAllBookingDates() {
        List<BookingDateDto> bookingDateDtoList = bookingDateService.findAllBookingDates();

        log.info(ControllerLogMessage.BookingDate.BOOKING_DATE_LISTED);
        return ResponseEntity.ok(bookingDateDtoList);
    }
}
