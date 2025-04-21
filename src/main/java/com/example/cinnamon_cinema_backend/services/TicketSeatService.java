package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.TicketSeatDTO;
import com.example.cinnamon_cinema_backend.entities.Ticket;
import com.example.cinnamon_cinema_backend.entities.TicketSeat;

import java.util.List;

public interface TicketSeatService {
    void bookTicket(TicketSeatDTO ticketSeat);

    void cancelTicket(Long id);

    void checkAvailability(Long seatId);

    void getSeatDetails(Long seatId);
//    void getAllSeatsInRoom(Long roomId);

    List<TicketSeatDTO> getAllTicketsSeat();

    List<TicketSeatDTO> getAllTicketsByTicketId(Long ticketId);

    TicketSeat addTicketSeat(TicketSeatDTO ticketSeat);
}
