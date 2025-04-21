package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.TicketSeatDTO;
import com.example.cinnamon_cinema_backend.entities.Seat;
import com.example.cinnamon_cinema_backend.entities.TicketSeat;
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

    @Override
    public void bookTicket(TicketSeatDTO ticketSeat) {
        TicketSeat ticketSeatEntity = ticketSeatRepo.findById(ticketSeat.getId())
                .orElseThrow(() -> new RuntimeException("Ticket seat not found"));
        ticketSeatEntity.setBooked(true);
        ticketSeatRepo.save(ticketSeatEntity);
        log.info("Ticket booked: {}", ticketSeat);
    }

    @Override
    public void cancelTicket(Long id) {
        TicketSeat ticketSeatEntity = ticketSeatRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket seat not found"));
        Seat seat = ticketSeatEntity.getSeat();
        seat.setAvailable(true);
        seatRepo.save(seat);

        ticketSeatRepo.save(ticketSeatEntity);
        log.info("Ticket cancelled: {}", id);

    }

    @Override
    public void checkAvailability(Long seatId) {

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
    public TicketSeat addTicketSeat(TicketSeatDTO ticketSeat) {
        log.info("Adding new ticket seat: {}", ticketSeat);
        TicketSeat ticketSeatEntity = ticketSeatMapper.toEntity(ticketSeat);
        TicketSeat savedTicketSeat = ticketSeatRepo.save(ticketSeatEntity);
        return savedTicketSeat;
    }
}
