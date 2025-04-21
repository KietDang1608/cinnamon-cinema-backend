package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.MovieImageDTO;
import com.example.cinnamon_cinema_backend.entities.MovieImage;
import com.example.cinnamon_cinema_backend.mappers.MovieImageMapper;
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
    private final MovieImageMapper movieImageMapper;

    @Override
    public void addMovieImage(MovieImageDTO movieImage) {
        MovieImage movieImageEntity = movieImageMapper.toEntity(movieImage);
        movieImageRepository.save(movieImageEntity);
        log.info("Movie image added: {}", movieImage);
    }

    @Override
    public void deleteMovieImage(Long id) {
        movieImageRepository.deleteById(id);
        log.info("Movie image deleted with id: {}", id);
    }

    @Override
    public List<MovieImageDTO> getAllMovieImages() {
        List<MovieImage> movieImages = movieImageRepository.findAll();
        log.info("Fetched all movie images");
        return movieImages.stream()
                .map(movieImageMapper::toDTO)
                .toList();
    }

    @Override
    public MovieImageDTO getMovieImageById(Long id) {
        MovieImage movieImage = movieImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie image not found with id: " + id));
        log.info("Fetched movie image with id: {}", id);
        return movieImageMapper.toDTO(movieImage);
    }

    @Override
    public List<MovieImageDTO> getMovieImagesByMovieId(Long movieId) {
        List<MovieImage> movieImages = movieImageRepository.findByMovieId(movieId);
        log.info("Fetched movie images for movie id: {}", movieId);
        return movieImages.stream()
                .map(movieImageMapper::toDTO)
                .toList();
    }
}
