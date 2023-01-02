package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.RoomRatingDto;
import com.bms.hotelbookingsystem.dto.request.CreateRoomRatingRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRoomRatingRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.RoomRatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/room-rating")
@Slf4j
public class RoomRatingController {
    private final RoomRatingService roomRatingService;

    public RoomRatingController(RoomRatingService roomRatingService) {
        this.roomRatingService = roomRatingService;
    }

    @PostMapping
    public ResponseEntity<Void> createRoomRating(@Valid @RequestBody CreateRoomRatingRequest request) {
        roomRatingService.createRoomRating(request);

        log.info(ControllerLogMessage.RoomRating.ROOM_RATING_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRoomRating(@PathVariable String id,
                                                 @Valid @RequestBody UpdateRoomRatingRequest request) {
        roomRatingService.updateRoomRating(id, request);

        log.info(ControllerLogMessage.RoomRating.ROOM_RATING_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomRating(@PathVariable String id) {
        roomRatingService.deleteRoomRating(id);

        log.info(ControllerLogMessage.RoomRating.ROOM_RATING_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomRatingDto> findRoomRatingById(@PathVariable String id) {
        RoomRatingDto roomRatingDto = roomRatingService.findRoomRatingById(id);

        log.info(ControllerLogMessage.RoomRating.ROOM_RATING_FOUND + id);
        return ResponseEntity.ok(roomRatingDto);
    }

    @GetMapping
    public ResponseEntity<List<RoomRatingDto>> findAllRoomRatings() {
        List<RoomRatingDto> roomRatingDtoList = roomRatingService.findAllRoomRatings();

        log.info(ControllerLogMessage.RoomRating.ROOM_RATING_LISTED);
        return ResponseEntity.ok(roomRatingDtoList);
    }
}
