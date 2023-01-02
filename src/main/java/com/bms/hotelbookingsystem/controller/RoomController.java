package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.RoomDto;
import com.bms.hotelbookingsystem.dto.request.CreateRoomRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRoomRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.model.RoomStatus;
import com.bms.hotelbookingsystem.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/room")
@Slf4j
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Void> createRoom(@RequestBody CreateRoomRequest request) {
        roomService.createRoom(request);

        log.info(ControllerLogMessage.Room.ROOM_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoom(@PathVariable String id, @RequestBody UpdateRoomRequest request) {
        roomService.updateRoom(id, request);

        log.info(ControllerLogMessage.Room.ROOM_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/roomStatus")
    public ResponseEntity<Void> updateRoomStatus(@PathVariable String id, @RequestParam RoomStatus status) {
        roomService.updateRoomStatus(id, status);

        log.info(ControllerLogMessage.Room.ROOM_STATUS_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/customer")
    public ResponseEntity<Void> updateRoomCustomer(@PathVariable String id, @RequestParam String customerId) {
        roomService.updateRoomCustomer(id, customerId);

        log.info(ControllerLogMessage.Room.ROOM_CUSTOMER_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findRoomById(@PathVariable String id) {
        RoomDto room = roomService.findRoomById(id);

        log.info(ControllerLogMessage.Room.ROOM_FOUND + id);
        return ResponseEntity.ok(room);
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> findAllRooms() {
        List<RoomDto> roomDtoList = roomService.findAllRooms();

        log.info(ControllerLogMessage.Room.ROOM_LISTED);
        return ResponseEntity.ok(roomDtoList);
    }
}
