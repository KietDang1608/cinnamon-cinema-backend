package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.RoomDTO;
import com.example.cinnamon_cinema_backend.entities.Room;
import com.example.cinnamon_cinema_backend.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        List<RoomDTO> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) {
        RoomDTO room = roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/cinema/{cinemaId}")
    public ResponseEntity<List<RoomDTO>> getRoomsByCinemaId(@PathVariable Long cinemaId) {
        List<RoomDTO> rooms = roomService.getAllRoomsByCinemaId(cinemaId);
        return ResponseEntity.ok(rooms);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> addRoom(@RequestBody RoomDTO room) {
        RoomDTO createdRoom = roomService.addRoom(room);
        return ResponseEntity.status(201).body(createdRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody RoomDTO room) {
        RoomDTO updatedRoom = roomService.updateRoom(id, room);
        if (updatedRoom != null) {
            return ResponseEntity.ok(updatedRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
