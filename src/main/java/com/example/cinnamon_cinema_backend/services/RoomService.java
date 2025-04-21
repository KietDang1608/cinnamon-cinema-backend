package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.RoomDTO;
import com.example.cinnamon_cinema_backend.entities.Cinema;
import com.example.cinnamon_cinema_backend.entities.Role;
import com.example.cinnamon_cinema_backend.entities.Room;

import java.util.List;

public interface RoomService {
    RoomDTO addRoom(RoomDTO room);

    void removeRoom(Long cinemaId, Long roomId);

    RoomDTO updateRoom(Long roomId, RoomDTO room);

    RoomDTO getRoomById(Long roomId);

    List<RoomDTO> getAllRoomsByCinemaId(Long cinemaId);

    List<RoomDTO> getAllRooms();
}
