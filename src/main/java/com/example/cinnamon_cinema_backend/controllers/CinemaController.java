package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.entities.Cinema;
import com.example.cinnamon_cinema_backend.services.CinemaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cinema")
public class CinemaController {
    private final CinemaService cinemaService;

    @GetMapping
    public ResponseEntity getAllCinemas() {
        return ResponseEntity.ok(cinemaService.getAllCinemas());
    }
    @GetMapping ( "/{id}")
    public ResponseEntity getCinemaById(@PathVariable Long id) {
        return ResponseEntity.ok(cinemaService.getCinemaById(id));
    }

    @PostMapping
    public ResponseEntity addCinema(@RequestBody Cinema cinema) {
        return ResponseEntity.ok(cinemaService.addCinema(cinema));
    }

    @PutMapping ("/{id}")
    public ResponseEntity updateCinema(@PathVariable Long id, @RequestBody Cinema cinema) {
        return ResponseEntity.ok(cinemaService.updateCinema(id, cinema));
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteCinema(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
        return ResponseEntity.ok("Cinema deleted successfully");
    }
}
