package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.ShowtimeDTO;
import com.example.cinnamon_cinema_backend.entities.Showtime;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShowtimeMapper {
    ShowtimeDTO toDTO(Showtime showtime);
    Showtime toEntity(ShowtimeDTO showtimeDTO);
}
