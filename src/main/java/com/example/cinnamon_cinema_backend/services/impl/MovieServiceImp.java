package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.MovieDTO;
import com.example.cinnamon_cinema_backend.entities.Movie;
import com.example.cinnamon_cinema_backend.mappers.MovieMapper;
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
    private final MovieMapper movieMapper;

    @Override
    public void addMovie(MovieDTO movie) {
        Movie movieEntity = movieMapper.toEntity(movie);
        movieRepo.save(movieEntity);
        log.info("Movie added: {}", movie);
    }

    @Override
    public void updateMovie(Long id, MovieDTO movie) {
        Movie movieEntity = movieMapper.toEntity(movie);
        movieEntity.setId(id);
        movieRepo.save(movieEntity);
        log.info("Movie updated: {}", movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
        log.info("Movie deleted with id: {}", id);
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepo.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        log.info("Movie found: {}", movie);
        return movieMapper.todDto(movie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepo.findAll();
        log.info("All movies found: {}", movies);
        return movies.stream().map(movieMapper::todDto).toList();
    }
}
