package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.CinemaDTO;
import com.example.cinnamon_cinema_backend.entities.Cinema;
import com.example.cinnamon_cinema_backend.services.CinemaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cinema")
public class CinemaController {
    private final CinemaService cinemaService;

    @GetMapping
    public ResponseEntity<List<CinemaDTO>> getAllCinemas() {
        return ResponseEntity.ok(cinemaService.getAllCinemas());
    }
    @GetMapping ( "/{id}")
    public ResponseEntity<CinemaDTO> getCinemaById(@PathVariable Long id) {
        return ResponseEntity.ok(cinemaService.getCinemaById(id));
    }

    @PostMapping
    public ResponseEntity<CinemaDTO> addCinema(@RequestBody CinemaDTO cinema) {
        return ResponseEntity.ok(cinemaService.addCinema(cinema));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<CinemaDTO> updateCinema(@PathVariable Long id, @RequestBody CinemaDTO cinema) {
        return ResponseEntity.ok(cinemaService.updateCinema(id, cinema));
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteCinema(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
        return ResponseEntity.ok("Cinema deleted successfully");
    }
}
