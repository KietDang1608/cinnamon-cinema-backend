package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.TicketSeatDTO;
import com.example.cinnamon_cinema_backend.entities.TicketSeat;
import com.example.cinnamon_cinema_backend.services.TicketSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ticket-seats")
public class TicketSeatController {
    private final TicketSeatService ticketSeatService;

    @GetMapping
    public ResponseEntity<List<TicketSeatDTO>> getAllTicketSeats() {
        List<TicketSeatDTO> ticketSeats = ticketSeatService.getAllTicketsSeat();
        return ResponseEntity.ok(ticketSeats);
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<TicketSeatDTO>> getTicketSeatsByTicketId(@PathVariable Long ticketId) {
        List<TicketSeatDTO> ticketSeats = ticketSeatService.getAllTicketsByTicketId(ticketId);
        return ResponseEntity.ok(ticketSeats);
    }

    @PostMapping
    public ResponseEntity<TicketSeatDTO> addTicketSeat(@RequestBody TicketSeatDTO ticketSeat) {
        TicketSeatDTO createdTicketSeat = ticketSeatService.addTicketSeat(ticketSeat);
        return ResponseEntity.status(201).body(createdTicketSeat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketSeat(@PathVariable Long id) {
        ticketSeatService.cancelTicket(id);
        return ResponseEntity.noContent().build();
    }
}
