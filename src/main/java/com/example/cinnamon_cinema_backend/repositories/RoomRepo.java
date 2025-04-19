package com.example.cinnamon_cinema_backend.repositories;

import com.example.cinnamon_cinema_backend.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
    List<Room> findAllByCinemaId(Long cinemaId);
    // Custom query methods can be defined here if needed
    // For example, find by name or other attributes
}
