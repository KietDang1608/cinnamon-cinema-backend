package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Ticket;

import java.util.List;

public interface TicketService {
    void createTicket(Ticket ticket);

    void cancelTicket(Long ticketId);

    void updateTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Long ticketId);

    List<Ticket> getTicketsByUserId(Long userId);
}
