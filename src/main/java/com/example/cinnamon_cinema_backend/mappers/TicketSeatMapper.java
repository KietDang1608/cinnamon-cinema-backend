package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.TicketSeatDTO;
import com.example.cinnamon_cinema_backend.entities.TicketSeat;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface TicketSeatMapper {
    TicketSeatDTO toDTO(TicketSeat ticketSeat);
    TicketSeat toEntity(TicketSeatDTO ticketSeatDTO);
}
