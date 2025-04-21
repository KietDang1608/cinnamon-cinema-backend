package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.MovieImageDTO;
import com.example.cinnamon_cinema_backend.entities.MovieImage;

import java.util.List;

public interface MovieImageService {
    void addMovieImage(MovieImageDTO movieImage);

    void deleteMovieImage(Long id);

    List<MovieImageDTO> getAllMovieImages();
    MovieImageDTO getMovieImageById(Long id);
    List<MovieImageDTO> getMovieImagesByMovieId(Long movieId);
}
