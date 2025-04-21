package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.CinemaDTO;
import com.example.cinnamon_cinema_backend.entities.Cinema;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CinemaMapper {
    CinemaDTO toDTO(Cinema cinema);
    Cinema toEntity(CinemaDTO cinemaDTO);
}
