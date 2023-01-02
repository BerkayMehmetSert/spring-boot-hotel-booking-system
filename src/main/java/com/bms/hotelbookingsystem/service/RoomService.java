package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.RoomDto;
import com.bms.hotelbookingsystem.dto.converter.RoomDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateRoomRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRoomRequest;
import com.bms.hotelbookingsystem.exception.RoomNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.Floor;
import com.bms.hotelbookingsystem.model.Room;
import com.bms.hotelbookingsystem.model.RoomStatus;
import com.bms.hotelbookingsystem.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomService {
    private final RoomRepository roomRepository;
    private final CustomerService customerService;
    private final RoomTypeService roomTypeService;
    private final BookingService bookingService;
    private final FloorService floorService;
    private final RoomDtoConverter converter;

    public RoomService(RoomRepository roomRepository,
                       CustomerService customerService,
                       RoomTypeService roomTypeService,
                       BookingService bookingService,
                       FloorService floorService,
                       RoomDtoConverter converter) {
        this.roomRepository = roomRepository;
        this.customerService = customerService;
        this.roomTypeService = roomTypeService;
        this.bookingService = bookingService;
        this.floorService = floorService;
        this.converter = converter;
    }

    public void createRoom(CreateRoomRequest request) {
        Room room = new Room();

        room.setRoomNumber(request.getRoomNumber());
        room.setIsSmoking(request.isSmoking());
        room.setCustomer(customerService.findCustomerByCustomerId(request.getCustomerId()));
        room.setRoomType(roomTypeService.findRoomTypeByRoomTypeId(request.getRoomTypeId()));
        room.setRoomStatus(request.getRoomStatus());
        room.setBooking(bookingService.findBookingByBookingId(request.getBookingId()));
        room.setFloor(floorService.findFloorByFloorId(request.getFloorId()));
        room.setCreatedAt(DateHelper.getCurrentDate());
        room.setUpdatedAt(DateHelper.getCurrentDate());

        roomRepository.save(room);
        log.info(BusinessLogMessage.Room.ROOM_CREATED);
    }

    public void updateRoom(final String id, UpdateRoomRequest request) {
        Room room = findRoomByRoomId(id);

        checkRoomNumberExists(request.getRoomNumber());

        room.setRoomNumber(request.getRoomNumber());
        room.setIsSmoking(request.isSmoking());
        room.setCustomer(customerService.findCustomerByCustomerId(request.getCustomerId()));
        room.setRoomType(roomTypeService.findRoomTypeByRoomTypeId(request.getRoomTypeId()));
        room.setRoomStatus(request.getRoomStatus());
        room.setBooking(bookingService.findBookingByBookingId(request.getBookingId()));
        room.setFloor(floorService.findFloorByFloorId(request.getFloorId()));
        room.setUpdatedAt(DateHelper.getCurrentDate());

        roomRepository.save(room);
        log.info(BusinessLogMessage.Room.ROOM_UPDATED + id);
    }

    public void updateRoomStatus(final String id, final RoomStatus status) {
        Room room = findRoomByRoomId(id);

        room.setRoomStatus(status);
        room.setUpdatedAt(DateHelper.getCurrentDate());

        roomRepository.save(room);
        log.info(BusinessLogMessage.Room.ROOM_STATUS_UPDATED + id);
    }

    public void updateRoomCustomer(final String id, final String customerId) {
        Room room = findRoomByRoomId(id);

        room.setCustomer(customerService.findCustomerByCustomerId(customerId));
        room.setUpdatedAt(DateHelper.getCurrentDate());

        roomRepository.save(room);
        log.info(BusinessLogMessage.Room.ROOM_CUSTOMER_UPDATED + id);
    }

    public void deleteRoom(final String id) {
        Room room = findRoomByRoomId(id);

        roomRepository.delete(room);
        log.info(BusinessLogMessage.Room.ROOM_DELETED + id);
    }

    public RoomDto findRoomById(final String id) {
        Room room = findRoomByRoomId(id);

        log.info(BusinessLogMessage.Room.ROOM_FOUND + id);
        return converter.convert(room);
    }

    public List<RoomDto> findAllRooms() {
        List<Room> roomList = roomRepository.findAll();

        if (roomList.isEmpty()) {
            log.error(BusinessMessage.Room.ROOM_LIST_EMPTY);
            throw new RoomNotFoundException(BusinessMessage.Room.ROOM_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Room.ROOM_LISTED);
        return converter.convert(roomList);
    }

    protected Room findRoomByRoomId(final String id) {
        return roomRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Room.ROOM_NOT_FOUND + id);
            throw new RoomNotFoundException(BusinessMessage.Room.ROOM_NOT_FOUND);
        });
    }

    private void checkRoomNumberExists(final String roomNumber) {
        if (roomRepository.existsByRoomNumber(roomNumber)) {
            log.error(BusinessLogMessage.Room.ROOM_ALREADY_EXISTS + roomNumber);
            throw new RoomNotFoundException(BusinessMessage.Room.ROOM_ALREADY_EXIST);
        }
    }
}
