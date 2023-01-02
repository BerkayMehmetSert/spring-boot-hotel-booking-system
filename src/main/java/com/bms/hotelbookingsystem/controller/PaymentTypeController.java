package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.PaymentTypeDto;
import com.bms.hotelbookingsystem.dto.request.CreatePaymentTypeRequest;
import com.bms.hotelbookingsystem.dto.request.UpdatePaymentTypeRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.PaymentTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment-type")
@Slf4j
public class PaymentTypeController {
    private final PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @PostMapping
    public ResponseEntity<Void> createPaymentType(@RequestBody CreatePaymentTypeRequest request) {
        paymentTypeService.createPaymentType(request);

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePaymentType(@PathVariable String id,
                                                  @RequestBody UpdatePaymentTypeRequest request) {
        paymentTypeService.updatePaymentType(id, request);

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentType(@PathVariable String id) {
        paymentTypeService.deletePaymentType(id);

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentTypeDto> findPaymentTypeById(@PathVariable String id) {
        PaymentTypeDto paymentTypeDto = paymentTypeService.findPaymentTypeById(id);

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_FOUND + id);
        return ResponseEntity.ok(paymentTypeDto);
    }

    @GetMapping
    public ResponseEntity<List<PaymentTypeDto>> findAllPaymentTypes() {
        List<PaymentTypeDto> paymentTypeDtoList = paymentTypeService.findAllPaymentTypes();

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_LISTED);
        return ResponseEntity.ok(paymentTypeDtoList);
    }
}
