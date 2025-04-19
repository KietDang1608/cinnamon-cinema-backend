package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Ticket;
import com.example.cinnamon_cinema_backend.repositories.TicketRepo;
import com.example.cinnamon_cinema_backend.repositories.TicketSeatRepo;
import com.example.cinnamon_cinema_backend.services.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TicketServiceImp implements TicketService {
    private final TicketSeatRepo ticketSeatRepo;
    private final TicketRepo ticketRepo;

    @Override
    public void createTicket(Ticket ticket) {
        log.info("Creating ticket: {}", ticket);
        // Implement the logic to save the ticket
        // For example, you can use a repository to save the ticket
        ticketRepo.save(ticket);
    }

    @Override
    public void cancelTicket(Long ticketId) {
        log.info("Cancelling ticket with id: {}", ticketId);
        // Implement the logic to cancel the ticket
        // For example, you can use a repository to delete the ticket by its ID
        // and update the seat availability
        ticketSeatRepo.deleteById(ticketId);
        ticketRepo.deleteById(ticketId);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        log.info("Updating ticket: {}", ticket);

    }

    @Override
    public List<Ticket> getAllTickets() {
        return List.of();
    }

    @Override
    public Ticket getTicketById(Long ticketId) {
        log.info("Fetching ticket with id: {}", ticketId);
        // Implement the logic to fetch a ticket by its ID
        // For example, you can use a repository to find the ticket by its ID
        return ticketRepo.findById(ticketId).orElse(null);
    }

    @Override
    public List<Ticket> getTicketsByUserId(Long userId) {
        log.info("Fetching tickets for user with id: {}", userId);
        // Implement the logic to fetch tickets by user ID
        // For example, you can use a repository to find tickets by user ID
        return ticketRepo.findByUserId(userId);
    }
}
