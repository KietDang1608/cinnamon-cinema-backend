package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.Seat;
import com.example.cinnamon_cinema_backend.dtos.SeatDTO;
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
        Seat seatEntity = seatMapper.toEntity(seat);
        seatRepo.save(seatEntity);
        log.info("Seat added: {}", seat);
        return seatMapper.toDto(seatEntity);
    }

    @Override
    public SeatDTO updateSeat(Long id, SeatDTO seat) {
        Seat seatEntity = seatMapper.toEntity(seat);
        seatEntity.setId(id);
        seatRepo.save(seatEntity);
        log.info("Seat updated: {}", seat);
        return seatMapper.toDto(seatEntity);
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepo.deleteById(id);
        log.info("Seat deleted with id: {}", id);
    }

    @Override
    public SeatDTO getSeatById(Long id) {
        Seat seat = seatRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        log.info("Seat found: {}", seat);
        return seatMapper.toDto(seat);
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
        List<Seat> seats = seatRepo.findByRoomId(roomId);
        log.info("Fetched seats for room id: {}", roomId);
        return seats.stream()
                .map(seatMapper::toDto)
                .toList();
    }

    @Override
    public List<SeatDTO> getAvailableSeatsByRoomId(Long roomId) {
        List<Seat> seats = seatRepo.findAvailableSeatsByRoomId(roomId);
        log.info("Fetched available seats for room id: {}", roomId);
        return seats.stream()
                .map(seatMapper::toDto)
                .toList();
    }
}
