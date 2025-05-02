package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.MovieDTO;
import com.example.cinnamon_cinema_backend.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "genres",ignore = true)
    MovieDTO todDto(Movie movie);
    @Mapping(target = "genres", ignore = true)
    Movie toEntity(MovieDTO movie);
}
