package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.RoomTypeDto;
import com.bms.hotelbookingsystem.dto.request.CreateRoomTypeRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRoomTypeRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.RoomTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/room-type")
@Slf4j
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @PostMapping
    public ResponseEntity<Void> createRoomType(@RequestBody CreateRoomTypeRequest request) {
        roomTypeService.createRoomType(request);

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoomType(@PathVariable String id, @RequestBody UpdateRoomTypeRequest request) {
        roomTypeService.updateRoomType(id, request);

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable String id) {
        roomTypeService.deleteRoomType(id);

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomTypeDto> findRoomTypeById(@PathVariable String id) {
        RoomTypeDto roomTypeDto = roomTypeService.findRoomTypeById(id);

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_FOUND + id);
        return ResponseEntity.ok(roomTypeDto);
    }

    @GetMapping
    public ResponseEntity<List<RoomTypeDto>> findAllRoomTypes() {
        List<RoomTypeDto> roomTypeDtoList = roomTypeService.findAllRoomTypes();

        log.info(ControllerLogMessage.RoomType.ROOM_TYPE_LISTED);
        return ResponseEntity.ok(roomTypeDtoList);
    }
}
