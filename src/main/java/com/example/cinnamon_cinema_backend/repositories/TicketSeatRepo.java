package com.example.cinnamon_cinema_backend.repositories;

import com.example.cinnamon_cinema_backend.entities.Ticket;
import com.example.cinnamon_cinema_backend.entities.TicketSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface TicketSeatRepo extends JpaRepository<TicketSeat, Long> {

    List<TicketSeat> findAllByTicketId(Long ticketId);

    List<TicketSeat> findByTicketId(Long ticketId);

    void deleteAllByTicket(Ticket ticket);
    // Custom query methods can be defined here if needed
    // For example, find by name or other attributes
}
