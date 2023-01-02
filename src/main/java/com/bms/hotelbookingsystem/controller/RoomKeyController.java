package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.RoomKeyDto;
import com.bms.hotelbookingsystem.dto.request.CreateRoomKeyRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRoomKeyRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.RoomKeyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/room-key")
@Slf4j
public class RoomKeyController {
    private final RoomKeyService roomKeyService;

    public RoomKeyController(RoomKeyService roomKeyService) {
        this.roomKeyService = roomKeyService;
    }

    @PostMapping
    public ResponseEntity<Void> createRoomKey(@Valid @RequestBody CreateRoomKeyRequest request){
        roomKeyService.createRoomKey(request);

        log.info(ControllerLogMessage.RoomKey.ROOM_KEY_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoomKey(@PathVariable String id,
                                              @Valid @RequestBody UpdateRoomKeyRequest request){
        roomKeyService.updateRoomKey(id, request);

        log.info(ControllerLogMessage.RoomKey.ROOM_KEY_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomKey(@PathVariable String id){
        roomKeyService.deleteRoomKey(id);

        log.info(ControllerLogMessage.RoomKey.ROOM_KEY_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomKeyDto> findRoomKeyById(@PathVariable String id){
        RoomKeyDto roomKeyDto = roomKeyService.findRoomKeyById(id);

        log.info(ControllerLogMessage.RoomKey.ROOM_KEY_FOUND + id);
        return ResponseEntity.ok(roomKeyDto);
    }

    @GetMapping
    public ResponseEntity<List<RoomKeyDto>> findAllRoomKeys(){
        List<RoomKeyDto> roomKeyDtoList = roomKeyService.findAllRoomKeys();

        log.info(ControllerLogMessage.RoomKey.ROOM_KEY_LISTED);
        return ResponseEntity.ok(roomKeyDtoList);
    }
}
