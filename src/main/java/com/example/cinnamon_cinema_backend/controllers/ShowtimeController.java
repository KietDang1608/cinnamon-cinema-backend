package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.ShowtimeDTO;
import com.example.cinnamon_cinema_backend.entities.Showtime;
import com.example.cinnamon_cinema_backend.services.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/showtimes")
public class ShowtimeController {
    private final ShowtimeService showtimeService;

    @GetMapping
    public ResponseEntity<List<ShowtimeDTO>> getAllShowtimes() {
        List<ShowtimeDTO> showtimes = showtimeService.getAllShowtimes();
        return ResponseEntity.ok(showtimes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ShowtimeDTO> getShowtimeById(@PathVariable Long id) {
        ShowtimeDTO showtime = showtimeService.getShowtimeById(id);
        if (showtime != null) {
            return ResponseEntity.ok(showtime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ShowtimeDTO>> getShowtimesByMovieId(@PathVariable Long movieId) {
        List<ShowtimeDTO> showtimes = showtimeService.getShowtimesByMovieId(movieId);
        return ResponseEntity.ok(showtimes);
    }
    @PostMapping
    public ResponseEntity<ShowtimeDTO> addShowtime(@RequestBody ShowtimeDTO showtime) {
        ShowtimeDTO createdShowtime = showtimeService.createShowtime(showtime);
        return ResponseEntity.status(201).body(createdShowtime);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ShowtimeDTO> updateShowtime(@PathVariable Long id, @RequestBody ShowtimeDTO showtime) {
        ShowtimeDTO updatedShowtime = showtimeService.updateShowtime(id, showtime);
        if (updatedShowtime != null) {
            return ResponseEntity.ok(updatedShowtime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return ResponseEntity.noContent().build();
    }
}
