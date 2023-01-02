package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.BillPaymentDto;
import com.bms.hotelbookingsystem.dto.request.CreateBillPaymentRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateBillPaymentRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.BillPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bill-payment")
@Slf4j
public class BillPaymentController {
    private final BillPaymentService billPaymentService;

    public BillPaymentController(BillPaymentService billPaymentService) {
        this.billPaymentService = billPaymentService;
    }

    @PostMapping
    public ResponseEntity<Void> createBillPayment(@Valid @RequestBody CreateBillPaymentRequest request) {
        billPaymentService.createBillPayment(request);

        log.info(ControllerLogMessage.BillPayment.BILL_PAYMENT_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBillPayment(@PathVariable String id,
                                                  @Valid @RequestBody UpdateBillPaymentRequest request) {
        billPaymentService.updateBillPayment(id, request);

        log.info(ControllerLogMessage.BillPayment.BILL_PAYMENT_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillPayment(@PathVariable String id) {
        billPaymentService.deleteBillPayment(id);

        log.info(ControllerLogMessage.BillPayment.BILL_PAYMENT_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillPaymentDto> findBillPaymentById(@PathVariable String id) {
        BillPaymentDto billPaymentDto = billPaymentService.findBillPaymentById(id);

        log.info(ControllerLogMessage.BillPayment.BILL_PAYMENT_FOUND + id);
        return ResponseEntity.ok(billPaymentDto);
    }

    @GetMapping
    public ResponseEntity<List<BillPaymentDto>> findAllBillPayments() {
        List<BillPaymentDto> billPaymentDtoList = billPaymentService.findAllBillPayments();

        log.info(ControllerLogMessage.BillPayment.BILL_PAYMENT_LISTED);
        return ResponseEntity.ok(billPaymentDtoList);
    }
}
