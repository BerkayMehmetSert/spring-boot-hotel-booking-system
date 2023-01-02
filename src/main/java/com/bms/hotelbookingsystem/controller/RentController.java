package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.RentDto;
import com.bms.hotelbookingsystem.dto.request.CreateRentRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRentRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.RentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rent")
@Slf4j
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    public ResponseEntity<Void> createRent(@Valid @RequestBody CreateRentRequest request) {
        rentService.createRent(request);

        log.info(ControllerLogMessage.Rent.RENT_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRent(@PathVariable String id,
                                           @Valid @RequestBody UpdateRentRequest request) {
        rentService.updateRent(id, request);

        log.info(ControllerLogMessage.Rent.RENT_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable String id) {
        rentService.deleteRent(id);

        log.info(ControllerLogMessage.Rent.RENT_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentDto> findRentById(@PathVariable String id) {
        RentDto rentDto = rentService.findRentById(id);

        log.info(ControllerLogMessage.Rent.RENT_FOUND + id);
        return ResponseEntity.ok(rentDto);
    }

    @GetMapping
    public ResponseEntity<List<RentDto>> findAllRents() {
        List<RentDto> rentDtoList = rentService.findAllRents();

        log.info(ControllerLogMessage.Rent.RENT_LISTED);
        return ResponseEntity.ok(rentDtoList);
    }
}
