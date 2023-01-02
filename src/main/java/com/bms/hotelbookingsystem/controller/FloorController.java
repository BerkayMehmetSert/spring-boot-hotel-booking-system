package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.FloorDto;
import com.bms.hotelbookingsystem.dto.request.CreateFloorRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateFloorRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.model.Floor;
import com.bms.hotelbookingsystem.service.FloorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/floor")
@Slf4j
public class FloorController {
    private final FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping
    public ResponseEntity<Void> createFloor(@Valid @RequestBody CreateFloorRequest request) {
        floorService.createFloor(request);

        log.info(ControllerLogMessage.Floor.FLOOR_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFloor(@PathVariable String id,
                                            @Valid @RequestBody UpdateFloorRequest request) {
        floorService.updateFloor(id, request);

        log.info(ControllerLogMessage.Floor.FLOOR_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFloor(@PathVariable String id) {
        floorService.deleteFloor(id);

        log.info(ControllerLogMessage.Floor.FLOOR_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FloorDto> findFloorById(@PathVariable String id) {
        FloorDto floorDto = floorService.findFloorById(id);

        log.info(ControllerLogMessage.Floor.FLOOR_FOUND + id);
        return ResponseEntity.ok(floorDto);
    }

    @GetMapping
    public ResponseEntity<List<FloorDto>> findAllFloors() {
        List<FloorDto> floorDtoList = floorService.findAllFloors();

        log.info(ControllerLogMessage.Floor.FLOOR_LISTED);
        return ResponseEntity.ok(floorDtoList);
    }
}
