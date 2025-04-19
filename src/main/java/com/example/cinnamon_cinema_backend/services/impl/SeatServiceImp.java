package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Seat;
import com.example.cinnamon_cinema_backend.repositories.SeatRepo;
import com.example.cinnamon_cinema_backend.services.SeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeatServiceImp implements SeatService {
    private final SeatRepo seatRepo;

    @Override
    public Seat addSeat(Seat seat) {
        log.info("Adding seat: {}", seat);
        // Implement the logic to save the seat
        // For example, you can use a repository to save the seat
        seatRepo.save(seat);
        return seat;
    }

    @Override
    public Seat updateSeat(Long id, Seat seat) {

        log.info("Updating seat: {}", seat);
        // Implement the logic to update the seat
        // For example, you can use a repository to update the seat
        Seat existingSeat = getSeatById(id);
        if (existingSeat != null) {
            existingSeat.setAvailable(seat.isAvailable());
            seatRepo.save(existingSeat);
        }
        return existingSeat;
    }

    @Override
    public void deleteSeat(Long id) {
        log.info("Deleting seat with id: {}", id);
        // Implement the logic to delete the seat
        // For example, you can use a repository to delete the seat by its ID
        seatRepo.deleteById(id);
    }

    @Override
    public Seat getSeatById(Long id) {
        log.info("Fetching seat with id: {}", id);
        // Implement the logic to fetch a seat by its ID
        // For example, you can use a repository to find the seat by its ID
        return seatRepo.findById(id).orElse(null);
    }

    @Override
    public List<Seat> getAllSeats() {
        log.info("Fetching all seats");
        // Implement the logic to fetch all seats
        // For example, you can use a repository to find all seats
        return seatRepo.findAll();
    }

    @Override
    public List<Seat> getSeatsByRoomId(Long roomId) {
        log.info("Fetching all seats for room with id: {}", roomId);
        // Implement the logic to fetch all seats for a specific room
        // For example, you can use a repository to find all seats by room ID
        return seatRepo.findAllByRoomId(roomId);
    }

    @Override
    public List<Seat> getAvailableSeatsByRoomId(Long roomId) {
        log.info("Fetching available seats for room with id: {}", roomId);
        // Implement the logic to fetch all available seats for a specific room
        // For example, you can use a repository to find all available seats by room ID
        return seatRepo.findAllByRoomIdAndAvailable(roomId, true);
    }
}
