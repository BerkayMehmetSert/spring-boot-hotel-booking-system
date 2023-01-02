package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.RentDto;
import com.bms.hotelbookingsystem.dto.converter.RentDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateRentRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRentRequest;
import com.bms.hotelbookingsystem.exception.RentNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.Rent;
import com.bms.hotelbookingsystem.repository.RentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RentService {
    private final RentRepository rentRepository;
    private final RoomTypeService roomTypeService;
    private final RentDtoConverter converter;

    public RentService(RentRepository rentRepository,
                       RoomTypeService roomTypeService,
                       RentDtoConverter converter) {
        this.rentRepository = rentRepository;
        this.roomTypeService = roomTypeService;
        this.converter = converter;
    }

    public void createRent(CreateRentRequest request) {
        Rent rent = new Rent();

        rent.setPrice(request.getPrice());
        rent.setRoomType(roomTypeService.findRoomTypeByRoomTypeId(request.getRoomTypeId()));
        rent.setCreatedAt(DateHelper.getCurrentDate());
        rent.setUpdatedAt(DateHelper.getCurrentDate());

        rentRepository.save(rent);
        log.info(BusinessLogMessage.Rent.RENT_CREATED);
    }

    public void updateRent(final String id, UpdateRentRequest request) {
        Rent rent = findRentByRentId(id);

        rent.setPrice(request.getPrice());
        rent.setRoomType(roomTypeService.findRoomTypeByRoomTypeId(request.getRoomTypeId()));
        rent.setUpdatedAt(DateHelper.getCurrentDate());

        rentRepository.save(rent);
        log.info(BusinessLogMessage.Rent.RENT_UPDATED + id);
    }

    public void deleteRent(final String id) {
        Rent rent = findRentByRentId(id);

        rentRepository.delete(rent);
        log.info(BusinessLogMessage.Rent.RENT_DELETED + id);
    }

    public RentDto findRentById(final String id) {
        Rent rent = findRentByRentId(id);

        log.info(BusinessLogMessage.Rent.RENT_FOUND + id);
        return converter.convert(rent);
    }

    public List<RentDto> findAllRents() {
        List<Rent> rentList = rentRepository.findAll();

        if (rentList.isEmpty()) {
            log.error(BusinessMessage.Rent.RENT_LIST_EMPTY);
            throw new RentNotFoundException(BusinessMessage.Rent.RENT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Rent.RENT_LISTED);
        return converter.convert(rentList);
    }

    protected Rent findRentByRentId(final String id) {
        return rentRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Rent.RENT_NOT_FOUND + id);
            throw new RentNotFoundException(BusinessMessage.Rent.RENT_NOT_FOUND);
        });
    }
}
