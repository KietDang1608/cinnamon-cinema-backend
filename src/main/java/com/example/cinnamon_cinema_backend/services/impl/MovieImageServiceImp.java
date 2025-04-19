package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.MovieImage;
import com.example.cinnamon_cinema_backend.repositories.MovieImageRepo;
import com.example.cinnamon_cinema_backend.services.MovieImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieImageServiceImp implements MovieImageService {
    private final MovieImageRepo movieImageRepository;

    @Override
    public void addMovieImage(MovieImage movieImage) {
        log.info("Adding movie image: {}", movieImage);
        // Implement the logic to save the movie image
        // For example, you can use a repository to save the movie image
        movieImageRepository.save(movieImage);
    }

    @Override
    public void deleteMovieImage(Long id) {
        log.info("Deleting movie image with name: {}", id);
        // Implement the logic to delete the movie image
        // For example, you can use a repository to delete the movie image by its name
        movieImageRepository.deleteById(id);
    }

    @Override
    public List<MovieImage> getAllMovieImages() {
        log.info("Fetching all movie images");
        // Implement the logic to fetch all movie images
        // For example, you can use a repository to find all movie images
        return movieImageRepository.findAll();
    }

    @Override
    public MovieImage getMovieImageById(Long id) {
        log.info("Fetching movie image with id: {}", id);
        // Implement the logic to fetch a movie image by its ID
        // For example, you can use a repository to find the movie image by its ID
        return movieImageRepository.findById(id).orElse(null);
    }

    @Override
    public List<MovieImage> getMovieImagesByMovieId(Long movieId) {
        log.info("Fetching movie images for movie with id: {}", movieId);
        // Implement the logic to fetch movie images by movie ID
        // For example, you can use a repository to find movie images by movie ID
        return movieImageRepository.findByMovieId(movieId);
    }
}
