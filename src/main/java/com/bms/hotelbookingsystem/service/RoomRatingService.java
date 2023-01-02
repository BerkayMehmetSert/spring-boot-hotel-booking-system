package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.RoomRatingDto;
import com.bms.hotelbookingsystem.dto.converter.RoomRatingDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateRoomRatingRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRoomRatingRequest;
import com.bms.hotelbookingsystem.exception.RoomRatingNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.RoomRating;
import com.bms.hotelbookingsystem.repository.RoomRatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomRatingService {
    private final RoomRatingRepository roomRatingRepository;
    private final RoomService roomService;
    private final CustomerService customerService;
    private final RatingService ratingService;
    private final RoomRatingDtoConverter converter;

    public RoomRatingService(RoomRatingRepository roomRatingRepository,
                             RoomService roomService,
                             CustomerService customerService,
                             RatingService ratingService,
                             RoomRatingDtoConverter converter) {
        this.roomRatingRepository = roomRatingRepository;
        this.roomService = roomService;
        this.customerService = customerService;
        this.ratingService = ratingService;
        this.converter = converter;
    }

    public void createRoomRating(CreateRoomRatingRequest request) {
        RoomRating roomRating = new RoomRating();

        roomRating.setName(request.getName());
        roomRating.setRoom(roomService.findRoomByRoomId(request.getRoomId()));
        roomRating.setCustomer(customerService.findCustomerByCustomerId(request.getCustomerId()));
        roomRating.setRating(ratingService.findRatingByRatingId(request.getRatingId()));
        roomRating.setCreatedAt(DateHelper.getCurrentDate());
        roomRating.setUpdatedAt(DateHelper.getCurrentDate());

        roomRatingRepository.save(roomRating);
        log.info(BusinessLogMessage.RoomRating.ROOM_RATING_CREATED);
    }

    public void updateRoomRating(final String id, UpdateRoomRatingRequest request) {
        RoomRating roomRating = findRoomRatingByRoomRatingId(id);

        roomRating.setName(request.getName());
        roomRating.setRoom(roomService.findRoomByRoomId(request.getRoomId()));
        roomRating.setCustomer(customerService.findCustomerByCustomerId(request.getCustomerId()));
        roomRating.setRating(ratingService.findRatingByRatingId(request.getRatingId()));
        roomRating.setUpdatedAt(DateHelper.getCurrentDate());

        roomRatingRepository.save(roomRating);
        log.info(BusinessLogMessage.RoomRating.ROOM_RATING_UPDATED + id);
    }

    public void deleteRoomRating(final String id) {
        RoomRating roomRating = findRoomRatingByRoomRatingId(id);

        roomRatingRepository.delete(roomRating);
        log.info(BusinessLogMessage.RoomRating.ROOM_RATING_DELETED + id);
    }

    public RoomRatingDto findRoomRatingById(final String id) {
        RoomRating roomRating = findRoomRatingByRoomRatingId(id);

        log.info(BusinessLogMessage.RoomRating.ROOM_RATING_FOUND + id);
        return converter.convert(roomRating);
    }

    public List<RoomRatingDto> findAllRoomRatings(){
        List<RoomRating> ratingList = roomRatingRepository.findAll();

        if (ratingList.isEmpty()) {
            log.error(BusinessLogMessage.RoomRating.ROOM_RATING_LIST_EMPTY);
            throw new RoomRatingNotFoundException(BusinessMessage.RoomRating.ROOM_RATING_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.RoomRating.ROOM_RATING_LISTED);
        return converter.convert(ratingList);
    }

    protected RoomRating findRoomRatingByRoomRatingId(final String id) {
        return roomRatingRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.RoomRating.ROOM_RATING_NOT_FOUND + id);
            throw new RoomRatingNotFoundException(BusinessMessage.RoomRating.ROOM_RATING_NOT_FOUND);
        });
    }
}
