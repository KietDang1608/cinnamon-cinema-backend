package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.SeatDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatDTO toDto(SeatDTO seatDTO);
    SeatDTO toEntity(SeatDTO seatDTO);
}
