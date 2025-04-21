package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.SeatDTO;
import com.example.cinnamon_cinema_backend.entities.Seat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatDTO toDto(Seat seat);
    Seat toEntity(SeatDTO seatDTO);
}
