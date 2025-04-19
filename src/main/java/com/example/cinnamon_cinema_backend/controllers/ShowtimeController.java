package com.example.cinnamon_cinema_backend.controllers;

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
    public ResponseEntity<List<Showtime>> getAllShowtimes() {
        List<Showtime> showtimes = showtimeService.getAllShowtimes();
        return ResponseEntity.ok(showtimes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable Long id) {
        Showtime showtime = showtimeService.getShowtimeById(id);
        if (showtime != null) {
            return ResponseEntity.ok(showtime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Showtime>> getShowtimesByMovieId(@PathVariable Long movieId) {
        List<Showtime> showtimes = showtimeService.getShowtimesByMovieId(movieId);
        return ResponseEntity.ok(showtimes);
    }
    @PostMapping
    public ResponseEntity<Showtime> addShowtime(@RequestBody Showtime showtime) {
        Showtime createdShowtime = showtimeService.createShowtime(showtime);
        return ResponseEntity.status(201).body(createdShowtime);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable Long id, @RequestBody Showtime showtime) {
        Showtime updatedShowtime = showtimeService.updateShowtime(id, showtime);
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
