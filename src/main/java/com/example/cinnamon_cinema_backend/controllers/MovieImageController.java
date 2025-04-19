package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.entities.MovieImage;
import com.example.cinnamon_cinema_backend.services.MovieImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie-images")
@RequiredArgsConstructor
public class MovieImageController {
    private final MovieImageService movieImageService;

    @GetMapping
    public ResponseEntity<List<MovieImage>> getAllMovieImages() {
        List<MovieImage> movieImages = movieImageService.getAllMovieImages();
        return ResponseEntity.ok(movieImages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieImage> getMovieImageById(@PathVariable Long id) {
        MovieImage movieImage = movieImageService.getMovieImageById(id);
        if (movieImage != null) {
            return ResponseEntity.ok(movieImage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> addMovieImage(@RequestBody MovieImage movieImage) {
        movieImageService.addMovieImage(movieImage);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteMovieImage( @PathVariable Long id) {
        movieImageService.deleteMovieImage(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<MovieImage>> getMovieImagesByMovieId(@PathVariable Long movieId) {
        List<MovieImage> movieImages = movieImageService.getMovieImagesByMovieId(movieId);
        return ResponseEntity.ok(movieImages);
    }
}
