package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Cinema;
import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.entities.Room;

import java.util.List;

public interface RoomService {
    Room addRoom(Room room);

    void removeRoom(Long cinemaId, Long roomId);

    Room updateRoom(Long roomId, Room room);

    Room getRoomById(Long roomId);

    List<Room> getAllRoomsByCinemaId(Long cinemaId);

    List<Room> getAllRooms();
}
