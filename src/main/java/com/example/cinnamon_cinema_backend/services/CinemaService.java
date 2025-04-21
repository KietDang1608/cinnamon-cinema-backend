package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.CinemaDTO;
import com.example.cinnamon_cinema_backend.entities.Cinema;

import java.util.List;

public interface CinemaService {
    // Define the methods that will be implemented in the service class
    // For example:
    CinemaDTO addCinema(CinemaDTO cinema);
    CinemaDTO updateCinema( Long id,CinemaDTO cinema);
    void deleteCinema(Long id);
    CinemaDTO getCinemaById(Long id);
    List<CinemaDTO> getAllCinemas();
}
