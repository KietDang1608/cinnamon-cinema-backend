package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.GenreDTO;
import com.example.cinnamon_cinema_backend.entities.Genre;
import com.example.cinnamon_cinema_backend.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenres() {

        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        Genre genre = genreService.getGenreById(id);
        if (genre != null) {
            return ResponseEntity.ok(genre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre) {
        Genre createdGenre = genreService.addGenre(genre);
        return ResponseEntity.status(201).body(createdGenre);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        Genre updatedGenre = genreService.updateGenre(id, genre);
        if (updatedGenre != null) {
            return ResponseEntity.ok(updatedGenre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
