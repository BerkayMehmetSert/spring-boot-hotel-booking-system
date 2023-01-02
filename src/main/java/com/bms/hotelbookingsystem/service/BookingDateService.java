package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.BookingDateDto;
import com.bms.hotelbookingsystem.dto.converter.BookingDateDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateBookingDateRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateBookingDateRequest;
import com.bms.hotelbookingsystem.exception.BookingDateNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.BookingDate;
import com.bms.hotelbookingsystem.repository.BookingDateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class BookingDateService {
    private final BookingDateRepository bookingDateRepository;
    private final BookingDateDtoConverter converter;

    public BookingDateService(BookingDateRepository bookingDateRepository, BookingDateDtoConverter converter) {
        this.bookingDateRepository = bookingDateRepository;
        this.converter = converter;
    }

    public void createBookingDate(CreateBookingDateRequest request) {
        BookingDate bookingDate = new BookingDate();

        bookingDate.setCheckInDate(request.getCheckInDate());
        bookingDate.setCheckOutDate(request.getCheckOutDate());
        bookingDate.setCreatedAt(DateHelper.getCurrentDate());
        bookingDate.setUpdatedAt(DateHelper.getCurrentDate());

        bookingDateRepository.save(bookingDate);
        log.info(BusinessLogMessage.BookingDate.BOOKING_DATE_CREATED);
    }

    public void updateBookingDate(final String id, UpdateBookingDateRequest request) {
        BookingDate bookingDate = findBookingDateByBookingDateId(id);

        bookingDate.setCheckInDate(request.getCheckInDate());
        bookingDate.setCheckOutDate(request.getCheckOutDate());
        bookingDate.setUpdatedAt(DateHelper.getCurrentDate());

        bookingDateRepository.save(bookingDate);
        log.info(BusinessLogMessage.BookingDate.BOOKING_DATE_UPDATED + id);
    }

    public void updateBookingDateCheckOutDate(final String id, final LocalDate checkOutDate) {
        BookingDate bookingDate = findBookingDateByBookingDateId(id);

        bookingDate.setCheckOutDate(checkOutDate);
        bookingDate.setUpdatedAt(DateHelper.getCurrentDate());

        bookingDateRepository.save(bookingDate);
        log.info(BusinessLogMessage.BookingDate.BOOKING_DATE_CHECK_OUT_DATE_UPDATED + id);
    }

    public void deleteBookingDate(final String id) {
        BookingDate bookingDate = findBookingDateByBookingDateId(id);

        bookingDateRepository.delete(bookingDate);
        log.info(BusinessLogMessage.BookingDate.BOOKING_DATE_DELETED + id);
    }

    public BookingDateDto findBookingDateById(final String id) {
        BookingDate bookingDate = findBookingDateByBookingDateId(id);

        log.info(BusinessLogMessage.BookingDate.BOOKING_DATE_FOUND + id);
        return converter.convert(bookingDate);
    }

    public List<BookingDateDto> findAllBookingDates() {
        List<BookingDate> bookingDateList = bookingDateRepository.findAll();

        if (bookingDateList.isEmpty()) {
            log.error(BusinessLogMessage.BookingDate.BOOKING_DATE_LIST_EMPTY);
            throw new BookingDateNotFoundException(BusinessMessage.BookingDate.BOOKING_DATE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.BookingDate.BOOKING_DATE_LISTED);
        return converter.convert(bookingDateList);
    }

    protected BookingDate findBookingDateByBookingDateId(final String id) {
        return bookingDateRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.BookingDate.BOOKING_DATE_NOT_FOUND + id);
            throw new BookingDateNotFoundException(BusinessMessage.BookingDate.BOOKING_DATE_NOT_FOUND);
        });
    }
}
