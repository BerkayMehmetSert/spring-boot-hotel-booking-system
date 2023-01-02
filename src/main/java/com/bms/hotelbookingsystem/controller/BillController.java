package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.BillDto;
import com.bms.hotelbookingsystem.dto.request.CreateBillRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateBillRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
@Slf4j
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<Void> createBill(@RequestBody CreateBillRequest request) {
        billService.createBill(request);

        log.info(ControllerLogMessage.Bill.BILL_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBill(@PathVariable String id, @RequestBody UpdateBillRequest request) {
        billService.updateBill(id, request);

        log.info(ControllerLogMessage.Bill.BILL_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable String id) {
        billService.deleteBill(id);

        log.info(ControllerLogMessage.Bill.BILL_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDto> findBillById(@PathVariable String id) {
        BillDto billDto = billService.findBillById(id);

        log.info(ControllerLogMessage.Bill.BILL_FOUND + id);
        return ResponseEntity.ok(billDto);
    }

    @GetMapping
    public ResponseEntity<List<BillDto>> findAllBills() {
        List<BillDto> billDtoList = billService.findAllBills();

        log.info(ControllerLogMessage.Bill.BILL_LISTED);
        return ResponseEntity.ok(billDtoList);
    }
}
