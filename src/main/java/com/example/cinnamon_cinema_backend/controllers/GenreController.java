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
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long id) {
        GenreDTO genreDTO = genreService.getGenreById(id);
        if (genreDTO != null) {
            return ResponseEntity.ok(genreDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<GenreDTO> addGenre(@RequestBody GenreDTO genre) {
        GenreDTO createdGenre = genreService.addGenre(genre);
        return ResponseEntity.status(201).body(createdGenre);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable Long id, @RequestBody GenreDTO genre) {
        GenreDTO updatedGenre = genreService.updateGenre(id, genre);
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
