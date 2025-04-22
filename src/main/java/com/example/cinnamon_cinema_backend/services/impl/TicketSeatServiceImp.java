package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.Seat;
import com.example.cinnamon_cinema_backend.dtos.SeatDTO;
import com.example.cinnamon_cinema_backend.dtos.TicketDTO;
import com.example.cinnamon_cinema_backend.dtos.TicketSeatDTO;
import com.example.cinnamon_cinema_backend.entities.TicketSeat;
import com.example.cinnamon_cinema_backend.mappers.SeatMapper;
import com.example.cinnamon_cinema_backend.mappers.TicketSeatMapper;
import com.example.cinnamon_cinema_backend.repositories.SeatRepo;
import com.example.cinnamon_cinema_backend.repositories.TicketSeatRepo;
import com.example.cinnamon_cinema_backend.services.TicketSeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketSeatServiceImp implements TicketSeatService {
    private final TicketSeatRepo ticketSeatRepo;
    private final TicketSeatMapper ticketSeatMapper;
    private final SeatRepo seatRepo;
    private final SeatMapper seatMapper;

    @Override
    public void bookTicket(TicketSeatDTO ticketSeat) {
        TicketSeat ticketSeatEntity = ticketSeatMapper.toEntity(ticketSeat);
        ticketSeatRepo.save(ticketSeatEntity);
        Seat seat = seatRepo.findById(ticketSeat.getSeatId())
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        seat.setAvailable(false);
        seatRepo.save(seat);
        log.info("Ticket booked: {}", ticketSeat);
    }

    @Override
    public void cancelTicket(Long id) {
        TicketSeat ticketSeat = ticketSeatRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket seat not found"));
        ticketSeatRepo.delete(ticketSeat);
        Seat seat = seatRepo.findById(ticketSeat.getTicket().getId())
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        seat.setAvailable(true);
        seatRepo.save(seat);
        log.info("Ticket cancelled: {}", id);
    }

    @Override
    public void checkAvailability(Long seatId) {
        Seat seat = seatRepo.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        if (seat.isAvailable()) {
            log.info("Seat is available: {}", seatId);
        } else {
            log.info("Seat is not available: {}", seatId);
        }
    }

    @Override
    public void getSeatDetails(Long seatId) {
        Seat seat = seatRepo.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        log.info("Seat details: {}", seat);
    }

    @Override
    public List<TicketSeatDTO> getAllTicketsSeat() {
        log.info("Fetching all ticket seats");
        return ticketSeatRepo.findAll().stream()
                .map(ticketSeatMapper::toDTO)
                .toList();
    }

    @Override
    public List<TicketSeatDTO> getAllTicketsByTicketId(Long ticketId) {
        log.info("Fetching all ticket seats for ticket ID: {}", ticketId);
        return ticketSeatRepo.findByTicketId(ticketId).stream()
                .map(ticketSeatMapper::toDTO)
                .toList();
    }

    @Override
    public TicketSeatDTO addTicketSeat(TicketSeatDTO ticketSeat) {
        TicketSeat ticketSeatEntity = ticketSeatMapper.toEntity(ticketSeat);
        TicketSeat savedTicketSeat = ticketSeatRepo.save(ticketSeatEntity);
        log.info("Ticket seat added: {}", savedTicketSeat);
        return ticketSeatMapper.toDTO(savedTicketSeat);
    }
}
