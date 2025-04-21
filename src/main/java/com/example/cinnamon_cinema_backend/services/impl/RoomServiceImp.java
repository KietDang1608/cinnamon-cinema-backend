package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.RoomDTO;
import com.example.cinnamon_cinema_backend.entities.Cinema;
import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.entities.Room;
import com.example.cinnamon_cinema_backend.mappers.RoomMapper;
import com.example.cinnamon_cinema_backend.repositories.RoomRepo;
import com.example.cinnamon_cinema_backend.services.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImp implements RoomService {
    private final RoomRepo roomRepo;
    private final RoomMapper roomMapper;

    @Override
    public RoomDTO addRoom(RoomDTO room) {
        log.info("Adding new room: {}", room);
        Room roomEntity = roomMapper.toEntity(room);
        Room savedRoom = roomRepo.save(roomEntity);
        return roomMapper.toDTO(savedRoom);
    }

    @Override
    public void removeRoom(Long cinemaId, Long roomId) {
        log.info("Removing room with id: {} from cinema with id: {}", roomId, cinemaId);
        Room room = roomRepo.findById(roomId).orElse(null);
        if (room != null && room.getCinema().getId().equals(cinemaId)) {
            roomRepo.delete(room);
        } else {
            log.warn("Room with id: {} not found in cinema with id: {}", roomId, cinemaId);
        }
    }

    @Override
    public RoomDTO updateRoom(Long roomId, RoomDTO room) {
        log.info("Updating room with id: {}", roomId);
        Room existingRoom = roomRepo.findById(roomId).orElse(null);
        if (existingRoom != null) {
            existingRoom.setName(room.getName());
            Room updatedRoom = roomRepo.save(existingRoom);
            return roomMapper.toDTO(updatedRoom);
        }
        return null;
    }

    @Override
    public RoomDTO getRoomById(Long roomId) {
        log.info("Fetching room with id: {}", roomId);
        return roomRepo.findById(roomId).map(roomMapper::toDTO).orElse(null);
    }

    @Override
    public List<RoomDTO> getAllRoomsByCinemaId(Long cinemaId) {
        log.info("Fetching all rooms for cinema with id: {}", cinemaId);
        return roomRepo.findAllByCinemaId(cinemaId).stream()
                .map(roomMapper::toDTO)
                .toList();
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        log.info("Fetching all rooms");
        return roomRepo.findAll().stream()
                .map(roomMapper::toDTO)
                .toList();
    }
}
