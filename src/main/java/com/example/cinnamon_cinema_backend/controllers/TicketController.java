package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.TicketDTO;
import com.example.cinnamon_cinema_backend.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        List<TicketDTO> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
        TicketDTO ticket = ticketService.getTicketById(id);
        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByUserId(@PathVariable Long userId) {
        List<TicketDTO> tickets = ticketService.getTicketsByUserId(userId);
        return ResponseEntity.ok(tickets);
    }

    @PostMapping
    public ResponseEntity<TicketDTO> addTicket(@RequestBody TicketDTO ticket) {
        TicketDTO createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.status(201).body(createdTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticket) {
        TicketDTO updatedTicket = ticketService.updateTicket(id, ticket);
        if (updatedTicket != null) {
            return ResponseEntity.ok(updatedTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.cancelTicket(id);
        return ResponseEntity.noContent().build();
    }
}
