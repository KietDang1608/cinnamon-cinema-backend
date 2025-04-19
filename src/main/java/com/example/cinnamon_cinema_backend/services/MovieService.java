package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Movie;

import java.util.List;

public interface MovieService {
    // Define the methods that will be implemented in the service class
    // For example:
    void addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(Long id);
    Movie getMovieById(Long id);
    List<Movie> getAllMovies();
}
