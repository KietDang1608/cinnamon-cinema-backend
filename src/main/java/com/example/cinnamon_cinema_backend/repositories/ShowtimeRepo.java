package com.example.cinnamon_cinema_backend.repositories;

import com.example.cinnamon_cinema_backend.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepo extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovieId(Long movieId);
    // Custom query methods can be defined here if needed
    // For example, find by name or other attributes

}
