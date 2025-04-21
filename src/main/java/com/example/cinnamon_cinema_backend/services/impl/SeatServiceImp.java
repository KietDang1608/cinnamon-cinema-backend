package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.SeatDTO;
import com.example.cinnamon_cinema_backend.entities.Seat;
import com.example.cinnamon_cinema_backend.mappers.SeatMapper;
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
    private final SeatMapper seatMapper;

    @Override
    public SeatDTO addSeat(SeatDTO seat) {
        log.info("Adding new seat: {}", seat);
        Seat seatEntity = seatMapper.toEntity(seat);
        Seat savedSeat = seatRepo.save(seatEntity);
        return seatMapper.toDto(savedSeat);
    }

    @Override
    public SeatDTO updateSeat(Long id, SeatDTO seat) {
        log.info("Updating seat with ID: {}", id);
        Seat seatEntity = seatRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        Seat updatedSeat = seatRepo.save(seatEntity);
        return seatMapper.toDto(updatedSeat);
    }

    @Override
    public void deleteSeat(Long id) {
        log.info("Deleting seat with ID: {}", id);
        Seat seatEntity = seatRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        seatRepo.delete(seatEntity);
        log.info("Deleted seat with ID: {}", id);
    }

    @Override
    public SeatDTO getSeatById(Long id) {
        log.info("Fetching seat with ID: {}", id);
        return seatRepo.findById(id)
                .map(seatMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
    }

    @Override
    public List<SeatDTO> getAllSeats() {
        log.info("Fetching all seats");
        return seatRepo.findAll().stream()
                .map(seatMapper::toDto)
                .toList();
    }

    @Override
    public List<SeatDTO> getSeatsByRoomId(Long roomId) {
        log.info("Fetching seats for room with ID: {}", roomId);
        return seatRepo.findByRoomId(roomId).stream()
                .map(seatMapper::toDto)
                .toList();
    }

    @Override
    public List<SeatDTO> getAvailableSeatsByRoomId(Long roomId) {
        log.info("Fetching available seats for room with ID: {}", roomId);
        return seatRepo.findAvailableSeatsByRoomId(roomId).stream()
                .map(seatMapper::toDto)
                .toList();
    }
}
