package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.MovieImageDTO;
import com.example.cinnamon_cinema_backend.entities.MovieImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieImageMapper {
    MovieImageDTO toDTO(MovieImage movieImage);
    MovieImage toEntity(MovieImageDTO movieImageDTO);
}
