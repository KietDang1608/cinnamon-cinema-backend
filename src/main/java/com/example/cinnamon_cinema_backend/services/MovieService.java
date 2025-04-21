package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.MovieDTO;
import com.example.cinnamon_cinema_backend.entities.Movie;

import java.util.List;

public interface MovieService {
    // Define the methods that will be implemented in the service class
    // For example:
    void addMovie(MovieDTO movie);
    void updateMovie(Long id, MovieDTO movie);
    void deleteMovie(Long id);
    MovieDTO getMovieById(Long id);
    List<MovieDTO> getAllMovies();
}
