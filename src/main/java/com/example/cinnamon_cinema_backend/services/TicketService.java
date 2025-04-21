package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.TicketDTO;
import com.example.cinnamon_cinema_backend.entities.Ticket;

import java.util.List;

public interface TicketService {
    void createTicket(TicketDTO ticket);

    void cancelTicket(Long ticketId);

    void updateTicket(Long id,TicketDTO ticket);

    List<TicketDTO> getAllTickets();

    TicketDTO getTicketById(Long ticketId);

    List<TicketDTO> getTicketsByUserId(Long userId);
}
