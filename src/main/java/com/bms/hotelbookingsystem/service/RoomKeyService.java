package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.RoomKeyDto;
import com.bms.hotelbookingsystem.dto.converter.RoomKeyDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateRoomKeyRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateRoomKeyRequest;
import com.bms.hotelbookingsystem.exception.RoomKeyNotFoundException;
import com.bms.hotelbookingsystem.helper.Generator;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.RoomKey;
import com.bms.hotelbookingsystem.repository.RoomKeyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomKeyService {
    private final RoomKeyRepository roomKeyRepository;
    private final RoomService roomService;
    private final RoomKeyDtoConverter converter;

    public RoomKeyService(RoomKeyRepository roomKeyRepository,
                          RoomService roomService,
                          RoomKeyDtoConverter converter) {
        this.roomKeyRepository = roomKeyRepository;
        this.roomService = roomService;
        this.converter = converter;
    }

    public void createRoomKey(CreateRoomKeyRequest request) {
        RoomKey roomKey = new RoomKey();

        roomKey.setKeyCode(Generator.generateKeyCode());
        roomKey.setIsActive(request.getIsActive());
        roomKey.setIsMaster(request.getIsMaster());
        roomKey.setRoom(roomService.findRoomByRoomId(request.getRoomId()));

        roomKeyRepository.save(roomKey);
        log.info(BusinessLogMessage.RoomKey.ROOM_KEY_CREATED);
    }

    public void updateRoomKey(final String id, UpdateRoomKeyRequest request) {
        RoomKey roomKey = findRoomKeyByRoomKeyId(id);

        roomKey.setIsActive(request.getIsActive());
        roomKey.setIsMaster(request.getIsMaster());
        roomKey.setRoom(roomService.findRoomByRoomId(request.getRoomId()));

        roomKeyRepository.save(roomKey);
        log.info(BusinessLogMessage.RoomKey.ROOM_KEY_UPDATED + id);
    }

    public void deleteRoomKey(final String id) {
        RoomKey roomKey = findRoomKeyByRoomKeyId(id);

        roomKeyRepository.delete(roomKey);
        log.info(BusinessLogMessage.RoomKey.ROOM_KEY_DELETED + id);
    }

    public RoomKeyDto findRoomKeyById(final String id) {
        RoomKey roomKey = findRoomKeyByRoomKeyId(id);

        log.info(BusinessLogMessage.RoomKey.ROOM_KEY_FOUND + id);
        return converter.convert(roomKey);
    }

    public List<RoomKeyDto> findAllRoomKeys() {
        List<RoomKey> roomKeys = roomKeyRepository.findAll();

        if (roomKeys.isEmpty()) {
            log.error(BusinessLogMessage.RoomKey.ROOM_KEY_LIST_EMPTY);
            throw new RoomKeyNotFoundException(BusinessMessage.RoomKey.ROOM_KEY_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.RoomKey.ROOM_KEY_LISTED);
        return converter.convert(roomKeys);
    }

    protected RoomKey findRoomKeyByRoomKeyId(final String id) {
        return roomKeyRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.RoomKey.ROOM_KEY_NOT_FOUND + id);
            throw new RoomKeyNotFoundException(BusinessMessage.RoomKey.ROOM_KEY_NOT_FOUND);
        });
    }
}
