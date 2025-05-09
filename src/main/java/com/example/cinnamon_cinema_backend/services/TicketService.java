package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.TicketDTO;

import java.util.List;

public interface TicketService {
    TicketDTO createTicket(TicketDTO ticket);

    void cancelTicket(Long ticketId);

    TicketDTO updateTicket(Long id,TicketDTO ticket);

    List<TicketDTO> getAllTickets();

    TicketDTO getTicketById(Long ticketId);

    List<TicketDTO> getTicketsByUserId(Long userId);
}
