package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Movie;
import com.example.cinnamon_cinema_backend.repositories.MovieRepo;
import com.example.cinnamon_cinema_backend.services.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService {
    private final MovieRepo movieRepo;

    @Override
    public void addMovie(Movie movie) {
        log.info("Adding movie: {}", movie);
        // Implement the logic to save the movie
        // For example, you can use a repository to save the movie
        movieRepo.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        log.info("Updating movie: {}", movie);
        // Implement the logic to update the movie
        // For example, you can use a repository to update the movie
        Movie existingMovie = getMovieById(movie.getId());
        if (existingMovie != null) {
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setDescription(movie.getDescription());
            existingMovie.setReleaseDate(movie.getReleaseDate());
            existingMovie.setDuration(movie.getDuration());
            existingMovie.setGenres(movie.getGenres());
            movieRepo.save(existingMovie);
        }
    }

    @Override
    public void deleteMovie(Long id) {
        log.info("Deleting movie with id: {}", id);
        // Implement the logic to delete the movie
        // For example, you can use a repository to delete the movie by its ID
        movieRepo.deleteById(id);
    }

    @Override
    public Movie getMovieById(Long id) {
        log.info("Fetching movie with id: {}", id);
        // Implement the logic to fetch a movie by its ID
        // For example, you can use a repository to find the movie by its ID
        return movieRepo.findById(id).orElse(null);
    }

    @Override
    public List<Movie> getAllMovies() {
        log.info("Fetching all movies");
        // Implement the logic to fetch all movies
        // For example, you can use a repository to find all movies
        return movieRepo.findAll();
    }
}
