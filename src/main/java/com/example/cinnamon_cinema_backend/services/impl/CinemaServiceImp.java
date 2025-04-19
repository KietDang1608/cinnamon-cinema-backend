package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Cinema;
import com.example.cinnamon_cinema_backend.repositories.CinemaRepo;
import com.example.cinnamon_cinema_backend.services.CinemaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CinemaServiceImp implements CinemaService {
    private final CinemaRepo cinemaRepo;

    @Override
    public List<Cinema> getAllCinemas() {
        log.info("Fetching all cinemas");
        return cinemaRepo.findAll();
    }
    @Override
    public Cinema getCinemaById(Long id) {
        log.info("Fetching cinema with id: {}", id);
        return cinemaRepo.findById(id).orElse(null);
    }
    @Override
    public Cinema addCinema(Cinema cinema) {
        log.info("Creating new cinema: {}", cinema);
        return cinemaRepo.save(cinema);
    }
    @Override
    public Cinema updateCinema(Long id, Cinema cinema) {
        log.info("Updating cinema with id: {}", id);
        Cinema existingCinema = getCinemaById(id);
        if (existingCinema != null) {
            existingCinema.setName(cinema.getName());
            existingCinema.setAddress(cinema.getAddress());
            return cinemaRepo.save(existingCinema);
        }
        return null;
    }
    @Override
    public void deleteCinema(Long id) {
        log.info("Deleting cinema with id: {}", id);
        cinemaRepo.deleteById(id);
    }


}
