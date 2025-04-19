package com.example.cinnamon_cinema_backend.repositories;

import com.example.cinnamon_cinema_backend.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Long> {
    List<Seat> findAllByRoomId(Long roomId);

    List<Seat> findAllByRoomIdAndAvailable(Long roomId, boolean b);
    // Custom query methods can be defined here if needed
    // For example, find by name or other attributes
}
