package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Cinema;
import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.entities.Room;
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

    @Override
    public Room addRoom(Room room) {
        log.info("Adding room: {} to cinema: {}", room);
        // Implement the logic to save the room
        // For example, you can use a repository to save the room
        roomRepo.save(room);
        return room;
    }

    @Override
    public void removeRoom(Long cinemaId, Long roomId) {
        log.info("Removing room with id: {} from cinema with id: {}", roomId, cinemaId);
        // Implement the logic to remove the room
        // For example, you can use a repository to delete the room by its ID
        roomRepo.deleteById(roomId);
    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
        log.info("Updating room with id: {} in cinema with id: {}", roomId);
        // Implement the logic to update the room
        // For example, you can use a repository to find the room by its ID and update it
        Room existingRoom = getRoomById(roomId);
        if (existingRoom != null) {
            existingRoom.setName(room.getName());

            roomRepo.save(existingRoom);
        }
        return existingRoom;
    }

    @Override
    public Room getRoomById(Long roomId) {
        log.info("Fetching room with id: {}", roomId);
        // Implement the logic to fetch a room by its ID
        // For example, you can use a repository to find the room by its ID
        return roomRepo.findById(roomId).orElse(null);
    }

    @Override
    public List<Room> getAllRoomsByCinemaId(Long cinemaId) {
        log.info("Fetching all rooms for cinema with id: {}", cinemaId);
        // Implement the logic to fetch all rooms for a specific cinema
        // For example, you can use a repository to find all rooms by cinema ID
        return roomRepo.findAllByCinemaId(cinemaId);
    }

    @Override
    public List<Room> getAllRooms() {
        log.info("Fetching all rooms");
        // Implement the logic to fetch all rooms
        // For example, you can use a repository to find all rooms
        return roomRepo.findAll();
    }
}
