package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.SeatDTO;
import com.example.cinnamon_cinema_backend.entities.Seat;

import java.util.List;

public interface SeatService {
    // Define the methods that will be implemented in the service class
    SeatDTO addSeat(SeatDTO seat);
    SeatDTO updateSeat(Long id,SeatDTO seat);
    void deleteSeat(Long id);
    SeatDTO getSeatById(Long id);
    List<SeatDTO> getAllSeats();
    List<SeatDTO> getSeatsByRoomId(Long roomId);
    List<SeatDTO> getAvailableSeatsByRoomId(Long roomId);
}
