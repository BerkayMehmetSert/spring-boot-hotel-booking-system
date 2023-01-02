package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.BillPaymentDto;
import com.bms.hotelbookingsystem.dto.converter.BillPaymentDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateBillPaymentRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateBillPaymentRequest;
import com.bms.hotelbookingsystem.exception.BillPaymentNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.BillPayment;
import com.bms.hotelbookingsystem.repository.BillPaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BillPaymentService {
    private final BillPaymentRepository billPaymentRepository;
    private final PaymentTypeService paymentTypeService;
    private final BookingDateService bookingDateService;
    private final BillPaymentDtoConverter converter;

    public BillPaymentService(BillPaymentRepository billPaymentRepository,
                              PaymentTypeService paymentTypeService,
                              BookingDateService bookingDateService,
                              BillPaymentDtoConverter converter) {
        this.billPaymentRepository = billPaymentRepository;
        this.paymentTypeService = paymentTypeService;
        this.bookingDateService = bookingDateService;
        this.converter = converter;
    }

    public void createBillPayment(CreateBillPaymentRequest request) {
        BillPayment billPayment = new BillPayment();

        billPayment.setPaymentType(paymentTypeService.findPaymentTypeByPaymentTypeId(request.getPaymentTypeId()));
        billPayment.setBookingDate(bookingDateService.findBookingDateByBookingDateId(request.getBookingDateId()));
        billPayment.setCreatedAt(DateHelper.getCurrentDate());
        billPayment.setUpdatedAt(DateHelper.getCurrentDate());

        billPaymentRepository.save(billPayment);
        log.info(BusinessLogMessage.BillPayment.BILL_PAYMENT_CREATED);
    }

    public void updateBillPayment(final String id, UpdateBillPaymentRequest request) {
        BillPayment billPayment = findBillPaymentByBillPaymentId(id);

        billPayment.setPaymentType(paymentTypeService.findPaymentTypeByPaymentTypeId(request.getPaymentTypeId()));
        billPayment.setBookingDate(bookingDateService.findBookingDateByBookingDateId(request.getBookingDateId()));
        billPayment.setUpdatedAt(DateHelper.getCurrentDate());

        billPaymentRepository.save(billPayment);
        log.info(BusinessLogMessage.BillPayment.BILL_PAYMENT_UPDATED + id);
    }

    public void deleteBillPayment(final String id) {
        BillPayment billPayment = findBillPaymentByBillPaymentId(id);

        billPaymentRepository.delete(billPayment);
        log.info(BusinessLogMessage.BillPayment.BILL_PAYMENT_DELETED + id);
    }

    public BillPaymentDto findBillPaymentById(final String id) {
        BillPayment billPayment = findBillPaymentByBillPaymentId(id);

        log.info(BusinessLogMessage.BillPayment.BILL_PAYMENT_FOUND + id);
        return converter.convert(billPayment);
    }

    public List<BillPaymentDto> findAllBillPayments() {
        List<BillPayment> billPaymentList = billPaymentRepository.findAll();

        if (billPaymentList.isEmpty()) {
            log.error(BusinessLogMessage.BillPayment.BILL_PAYMENT_LIST_EMPTY);
            throw new BillPaymentNotFoundException(BusinessMessage.BillPayment.BILL_PAYMENT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.BillPayment.BILL_PAYMENT_LISTED);
        return converter.convert(billPaymentList);
    }

    protected BillPayment findBillPaymentByBillPaymentId(final String id) {
        return billPaymentRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.BillPayment.BILL_PAYMENT_NOT_FOUND + id);
            throw new BillPaymentNotFoundException(BusinessMessage.BillPayment.BILL_PAYMENT_NOT_FOUND);
        });
    }
}
