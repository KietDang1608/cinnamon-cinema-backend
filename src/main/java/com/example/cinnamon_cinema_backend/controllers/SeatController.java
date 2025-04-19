package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.entities.Seat;
import com.example.cinnamon_cinema_backend.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/seats")
public class SeatController {
    private final SeatService seatService;

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id) {
        Seat seat = seatService.getSeatById(id);
        if (seat != null) {
            return ResponseEntity.ok(seat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<Seat>> getSeatsByRoomId(@PathVariable Long roomId) {
        List<Seat> seats = seatService.getSeatsByRoomId(roomId);
        return ResponseEntity.ok(seats);
    }

    @PostMapping
    public ResponseEntity<Seat> addSeat(@RequestBody Seat seat) {
        Seat createdSeat = seatService.addSeat(seat);
        return ResponseEntity.status(201).body(createdSeat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat seat) {
        Seat updatedSeat = seatService.updateSeat(id, seat);
        if (updatedSeat != null) {
            return ResponseEntity.ok(updatedSeat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/room/{roomId}/available")
    public ResponseEntity<List<Seat>> getAvailableSeatsByRoomId(@PathVariable Long roomId) {
        List<Seat> availableSeats = seatService.getAvailableSeatsByRoomId(roomId);
        return ResponseEntity.ok(availableSeats);
    }


}
