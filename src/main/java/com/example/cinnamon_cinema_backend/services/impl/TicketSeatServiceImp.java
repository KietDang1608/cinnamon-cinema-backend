package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.TicketSeat;
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

    @Override
    public void bookTicket(TicketSeat ticketSeat) {
        log.info("Booking ticket for seat: {}", ticketSeat);
        // Implement the logic to save the ticket seat
        // For example, you can use a repository to save the ticket seat
        ticketSeatRepo.save(ticketSeat);
    }

    @Override
    public void cancelTicket(Long id) {
        log.info("Cancelling ticket with id: {}", id);
        // Implement the logic to cancel the ticket
        // For example, you can use a repository to delete the ticket seat by its ID
        ticketSeatRepo.deleteById(id);
    }

    @Override
    public void checkAvailability(Long seatId) {
        log.info("Checking availability for seat with id: {}", seatId);

    }

    @Override
    public void getSeatDetails(Long seatId) {
        log.info("Fetching details for seat with id: {}", seatId);
        // Implement the logic to fetch seat details
        // For example, you can use a repository to find the seat by its ID
        ticketSeatRepo.findById(seatId).ifPresent(seat -> log.info("Seat details: {}", seat));
    }

//    @Override
//    public void getAllSeatsInRoom(Long roomId) {
//        log.info("Fetching all seats in room with id: {}", roomId);
//        // Implement the logic to fetch all seats in a specific room
//        // For example, you can use a repository to find all seats by room ID
//        ticketSeatRepo.findAllByRoom_Id(roomId).forEach(seat -> log.info("Seat: {}", seat));
//    }

    @Override
    public List<TicketSeat> getAllTicketsSeat() {
        log.info("Fetching all ticket seats");
        // Implement the logic to fetch all ticket seats
        // For example, you can use a repository to find all ticket seats
        return ticketSeatRepo.findAll();
    }

    @Override
    public List<TicketSeat> getAllTicketsByTicketId(Long ticketId) {
        log.info("Fetching all ticket seats for ticket with id: {}", ticketId);
        // Implement the logic to fetch all ticket seats by ticket ID
        // For example, you can use a repository to find all ticket seats by ticket ID
        return ticketSeatRepo.findAllByTicketId(ticketId);
    }

    @Override
    public TicketSeat addTicketSeat(TicketSeat ticketSeat) {
        log.info("Adding ticket seat: {}", ticketSeat);
        // Implement the logic to save the ticket seat
        // For example, you can use a repository to save the ticket seat
        return ticketSeatRepo.save(ticketSeat);
    }
}
