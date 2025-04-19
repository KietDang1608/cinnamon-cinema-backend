package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.MovieImage;

import java.util.List;

public interface MovieImageService {
    void addMovieImage(MovieImage movieImage);

    void deleteMovieImage(Long id);

    List<MovieImage> getAllMovieImages();
    MovieImage getMovieImageById(Long id);
    List<MovieImage> getMovieImagesByMovieId(Long movieId);
}
