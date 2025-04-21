package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.MovieDTO;
import com.example.cinnamon_cinema_backend.entities.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO todDto(Movie movie);
    Movie toEntity(MovieDTO movie);
}
