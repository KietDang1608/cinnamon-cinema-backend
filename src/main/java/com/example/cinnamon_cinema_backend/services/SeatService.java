package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Seat;

import java.util.List;

public interface SeatService {
    // Define the methods that will be implemented in the service class
    Seat addSeat(Seat seat);
    Seat updateSeat(Long id,Seat seat);
    void deleteSeat(Long id);
    Seat getSeatById(Long id);
    List<Seat> getAllSeats();
    List<Seat> getSeatsByRoomId(Long roomId);
    List<Seat> getAvailableSeatsByRoomId(Long roomId);
}
