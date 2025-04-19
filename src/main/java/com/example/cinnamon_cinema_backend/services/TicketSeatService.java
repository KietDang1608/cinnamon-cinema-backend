package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Ticket;
import com.example.cinnamon_cinema_backend.entities.TicketSeat;

import java.util.List;

public interface TicketSeatService {
    void bookTicket(TicketSeat ticketSeat);

    void cancelTicket(Long id);

    void checkAvailability(Long seatId);

    void getSeatDetails(Long seatId);
//    void getAllSeatsInRoom(Long roomId);

    List<TicketSeat> getAllTicketsSeat();

    List<TicketSeat> getAllTicketsByTicketId(Long ticketId);

    TicketSeat addTicketSeat(TicketSeat ticketSeat);
}
