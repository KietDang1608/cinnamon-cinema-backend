package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.SeatDTO;
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
    public ResponseEntity<List<SeatDTO>> getAllSeats() {
        List<SeatDTO> seatDTOS = seatService.getAllSeats();
        return ResponseEntity.ok(seatDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatDTO> getSeatById(@PathVariable Long id) {
        SeatDTO seatDTO = seatService.getSeatById(id);
        if (seatDTO != null) {
            return ResponseEntity.ok(seatDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<SeatDTO>> getSeatsByRoomId(@PathVariable Long roomId) {
        List<SeatDTO> seatDTOS = seatService.getSeatsByRoomId(roomId);
        return ResponseEntity.ok(seatDTOS);
    }

    @PostMapping
    public ResponseEntity<SeatDTO> addSeat(@RequestBody SeatDTO seatDTO) {
        SeatDTO createdSeatDTO = seatService.addSeat(seatDTO);
        return ResponseEntity.status(201).body(createdSeatDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatDTO> updateSeat(@PathVariable Long id, @RequestBody SeatDTO seatDTO) {
        SeatDTO updatedSeatDTO = seatService.updateSeat(id, seatDTO);
        if (updatedSeatDTO != null) {
            return ResponseEntity.ok(updatedSeatDTO);
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
    public ResponseEntity<List<SeatDTO>> getAvailableSeatsByRoomId(@PathVariable Long roomId) {
        List<SeatDTO> availableSeatDTOS = seatService.getAvailableSeatsByRoomId(roomId);
        return ResponseEntity.ok(availableSeatDTOS);
    }


}
