package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.GenreDTO;
import com.example.cinnamon_cinema_backend.entities.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDTO toDTO(Genre genre);
    Genre toEntity(GenreDTO genreDTO);


}
