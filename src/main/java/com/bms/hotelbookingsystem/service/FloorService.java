package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.FloorDto;
import com.bms.hotelbookingsystem.dto.converter.FloorDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateFloorRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateFloorRequest;
import com.bms.hotelbookingsystem.exception.FloorAlreadyExistException;
import com.bms.hotelbookingsystem.exception.FloorNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.Floor;
import com.bms.hotelbookingsystem.repository.FloorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FloorService {
    private final FloorRepository floorRepository;
    private final FloorDtoConverter converter;

    public FloorService(FloorRepository floorRepository, FloorDtoConverter converter) {
        this.floorRepository = floorRepository;
        this.converter = converter;
    }

    public void createFloor(CreateFloorRequest request) {
        Floor floor = new Floor();

        checkIfFloorExists(request.getNumber());

        floor.setNumber(request.getNumber());
        floor.setCreatedAt(DateHelper.getCurrentDate());
        floor.setUpdatedAt(DateHelper.getCurrentDate());

        floorRepository.save(floor);
        log.info(BusinessLogMessage.Floor.FLOOR_CREATED);
    }

    public void updateFloor(final String id, UpdateFloorRequest request) {
        Floor floor = findFloorByFloorId(id);

        checkIfFloorExists(request.getNumber());

        floor.setNumber(request.getNumber());
        floor.setUpdatedAt(DateHelper.getCurrentDate());

        floorRepository.save(floor);
        log.info(BusinessLogMessage.Floor.FLOOR_UPDATED + id);
    }

    public void deleteFloor(final String id) {
        Floor floor = findFloorByFloorId(id);

        floorRepository.delete(floor);
        log.info(BusinessLogMessage.Floor.FLOOR_DELETED + id);
    }

    public FloorDto findFloorById(final String id) {
        Floor floor = findFloorByFloorId(id);

        log.info(BusinessLogMessage.Floor.FLOOR_FOUND + id);
        return converter.convert(floor);
    }

    public List<FloorDto> findAllFloors() {
        List<Floor> floorList = floorRepository.findAll();

        if (floorList.isEmpty()) {
            log.info(BusinessLogMessage.Floor.FLOOR_LIST_EMPTY);
            throw new FloorNotFoundException(BusinessMessage.Floor.FLOOR_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Floor.FLOOR_LISTED);
        return converter.convert(floorList);
    }

    private void checkIfFloorExists(String number) {
        if (floorRepository.existsByNumber(number)) {
            log.error(BusinessLogMessage.Floor.FLOOR_ALREADY_EXISTS + number);
            throw new FloorAlreadyExistException(BusinessMessage.Floor.FLOOR_ALREADY_EXIST);
        }
    }

    protected Floor findFloorByFloorId(final String id) {
        return floorRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Floor.FLOOR_NOT_FOUND + id);
            throw new FloorNotFoundException(BusinessMessage.Floor.FLOOR_NOT_FOUND);
        });
    }
}
