package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.RoomTypeDto;
import com.bms.hotelbookingsystem.dto.converter.RoomTypeDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateRoomTypeRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRoomTypeRequest;
import com.bms.hotelbookingsystem.exception.RoomTypeAlreadyExistException;
import com.bms.hotelbookingsystem.exception.RoomTypeNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.RoomType;
import com.bms.hotelbookingsystem.repository.RoomTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;
    private final RoomTypeDtoConverter converter;

    public RoomTypeService(RoomTypeRepository roomTypeRepository, RoomTypeDtoConverter converter) {
        this.roomTypeRepository = roomTypeRepository;
        this.converter = converter;
    }

    public void createRoomType(CreateRoomTypeRequest request) {
        RoomType roomType = new RoomType();

        checkIfRoomTypeExists(request.getName());

        roomType.setName(request.getName());
        roomType.setCreatedAt(DateHelper.getCurrentDate());
        roomType.setUpdatedAt(DateHelper.getCurrentDate());

        roomTypeRepository.save(roomType);
        log.info(BusinessLogMessage.RoomType.ROOM_TYPE_CREATED);
    }

    public void updateRoomType(final String id, UpdateRoomTypeRequest request) {
        RoomType roomType = findRoomTypeByRoomTypeId(id);

        if (!roomType.getName().equals(request.getName())) {
            checkIfRoomTypeExists(request.getName());
        }

        roomType.setName(request.getName());
        roomType.setUpdatedAt(DateHelper.getCurrentDate());

        roomTypeRepository.save(roomType);
        log.info(BusinessLogMessage.RoomType.ROOM_TYPE_UPDATED + id);
    }

    public void deleteRoomType(final String id) {
        RoomType roomType = findRoomTypeByRoomTypeId(id);

        roomTypeRepository.delete(roomType);
        log.info(BusinessLogMessage.RoomType.ROOM_TYPE_DELETED + id);
    }

    public RoomTypeDto findRoomTypeById(final String id) {
        RoomType roomType = findRoomTypeByRoomTypeId(id);

        log.info(BusinessLogMessage.RoomType.ROOM_TYPE_FOUND + id);
        return converter.convert(roomType);
    }

    public List<RoomTypeDto> findAllRoomTypes() {
        List<RoomType> roomTypeList = roomTypeRepository.findAll();

        if (roomTypeList.isEmpty()) {
            log.error(BusinessLogMessage.RoomType.ROOM_TYPE_LIST_EMPTY);
            throw new RoomTypeNotFoundException(BusinessMessage.RoomType.ROOM_TYPE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.RoomType.ROOM_TYPE_LISTED);
        return converter.convert(roomTypeList);
    }

    private void checkIfRoomTypeExists(final String name) {
        if (roomTypeRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.RoomType.ROOM_TYPE_ALREADY_EXISTS + name);
            throw new RoomTypeAlreadyExistException(BusinessMessage.RoomType.ROOM_TYPE_ALREADY_EXIST);
        }
    }

    protected RoomType findRoomTypeByRoomTypeId(final String id) {
        return roomTypeRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.RoomType.ROOM_TYPE_NOT_FOUND + id);
            throw new RoomTypeAlreadyExistException(BusinessMessage.RoomType.ROOM_TYPE_NOT_FOUND);
        });
    }
}
