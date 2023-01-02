package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.RatingDto;
import com.bms.hotelbookingsystem.dto.request.CreateRatingRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRatingRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rating")
@Slf4j
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Void> createRating(@RequestBody CreateRatingRequest request) {
        ratingService.createRating(request);

        log.info(ControllerLogMessage.Rating.RATING_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRating(@PathVariable String id, @RequestBody UpdateRatingRequest request) {
        ratingService.updateRating(id, request);

        log.info(ControllerLogMessage.Rating.RATING_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);

        log.info(ControllerLogMessage.Rating.RATING_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> findRatingById(@PathVariable String id) {
        RatingDto ratingDto = ratingService.findRatingById(id);

        log.info(ControllerLogMessage.Rating.RATING_FOUND + id);
        return ResponseEntity.ok(ratingDto);
    }

    @GetMapping
    public ResponseEntity<List<RatingDto>> findAllRatings() {
        List<RatingDto> ratingDtoList = ratingService.findAllRatings();

        log.info(ControllerLogMessage.Rating.RATING_LISTED);
        return ResponseEntity.ok(ratingDtoList);
    }
}
