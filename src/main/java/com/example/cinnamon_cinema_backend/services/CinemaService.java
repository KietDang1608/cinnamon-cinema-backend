package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Cinema;

import java.util.List;

public interface CinemaService {
    // Define the methods that will be implemented in the service class
    // For example:
    Cinema addCinema(Cinema cinema);
    Cinema updateCinema( Long id,Cinema cinema);
    void deleteCinema(Long id);
    Cinema getCinemaById(Long id);
    List<Cinema> getAllCinemas();
}
