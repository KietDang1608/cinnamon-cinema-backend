package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.TicketDTO;
import com.example.cinnamon_cinema_backend.entities.Ticket;
import com.example.cinnamon_cinema_backend.mappers.TicketMapper;
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
    private final TicketMapper ticketMapper;

    @Override
    public void createTicket(TicketDTO ticket) {
        Ticket ticketEntity = ticketMapper.toEntity(ticket);
        ticketRepo.save(ticketEntity);
        log.info("Ticket created: {}", ticket);
    }

    @Override
    public void cancelTicket(Long ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketSeatRepo.deleteAllByTicket(ticket);
        ticketRepo.delete(ticket);
        log.info("Ticket cancelled: {}", ticketId);
    }

    @Override
    public void updateTicket(Long id, TicketDTO ticket) {
        Ticket ticketEntity = ticketMapper.toEntity(ticket);
        ticketEntity.setId(id);
        ticketRepo.save(ticketEntity);
        log.info("Ticket updated: {}", ticket);
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        log.info("Fetching all tickets");
        return ticketRepo.findAll().stream()
                .map(ticketMapper::toDTO)
                .toList();
    }

    @Override
    public TicketDTO getTicketById(Long ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        log.info("Ticket found: {}", ticket);
        return ticketMapper.toDTO(ticket);
    }

    @Override
    public List<TicketDTO> getTicketsByUserId(Long userId) {
        log.info("Fetching tickets for user with ID: {}", userId);
        return ticketRepo.findByUserId(userId).stream()
                .map(ticketMapper::toDTO)
                .toList();
    }
}
