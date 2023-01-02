package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.BookingDto;
import com.bms.hotelbookingsystem.dto.converter.BookingDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateBookingRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateBookingRequest;
import com.bms.hotelbookingsystem.exception.BookingNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.Booking;
import com.bms.hotelbookingsystem.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final BookingDateService bookingDateService;
    private final BookingDtoConverter converter;

    public BookingService(BookingRepository bookingRepository,
                          CustomerService customerService,
                          BookingDateService bookingDateService,
                          BookingDtoConverter converter) {
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
        this.bookingDateService = bookingDateService;
        this.converter = converter;
    }

    public void createBooking(CreateBookingRequest request) {
        Booking booking = new Booking();

        booking.setCustomer(customerService.findCustomerByCustomerId(request.getCustomerId()));
        booking.setBookingDate(bookingDateService.findBookingDateByBookingDateId(request.getBookingDateId()));
        booking.setCreatedAt(DateHelper.getCurrentDate());
        booking.setUpdatedAt(DateHelper.getCurrentDate());

        bookingRepository.save(booking);
        log.info(BusinessLogMessage.Booking.BOOKING_CREATED);
    }

    public void updateBooking(final String id, UpdateBookingRequest request) {
        Booking booking = findBookingByBookingId(id);

        booking.setCustomer(customerService.findCustomerByCustomerId(request.getCustomerId()));
        booking.setBookingDate(bookingDateService.findBookingDateByBookingDateId(request.getBookingDateId()));
        booking.setUpdatedAt(DateHelper.getCurrentDate());

        bookingRepository.save(booking);
        log.info(BusinessLogMessage.Booking.BOOKING_UPDATED + id);
    }

    public void deleteBooking(final String id) {
        Booking booking = findBookingByBookingId(id);

        bookingRepository.delete(booking);
        log.info(BusinessLogMessage.Booking.BOOKING_DELETED + id);
    }

    public BookingDto findBookingById(final String id) {
        Booking booking = findBookingByBookingId(id);

        log.info(BusinessLogMessage.Booking.BOOKING_FOUND + id);
        return converter.convert(booking);
    }

    public List<BookingDto> findAllBookings() {
        List<Booking> bookingList = bookingRepository.findAll();

        if (bookingList.isEmpty()) {
            log.error(BusinessLogMessage.Booking.BOOKING_LIST_EMPTY);
            throw new BookingNotFoundException(BusinessMessage.Booking.BOOKING_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Booking.BOOKING_LISTED);
        return converter.convert(bookingList);
    }

    protected Booking findBookingByBookingId(final String id) {
        return bookingRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Booking.BOOKING_NOT_FOUND + id);
            throw new BookingNotFoundException(BusinessMessage.Booking.BOOKING_NOT_FOUND);
        });
    }
}
