package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.CinemaDTO;
import com.example.cinnamon_cinema_backend.entities.Cinema;
import com.example.cinnamon_cinema_backend.mappers.CinemaMapper;
import com.example.cinnamon_cinema_backend.repositories.CinemaRepo;
import com.example.cinnamon_cinema_backend.services.CinemaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CinemaServiceImp implements CinemaService {
    private final CinemaRepo cinemaRepo;
    private final CinemaMapper cinemaMapper;

    @Override
    public List<CinemaDTO> getAllCinemas() {
        log.info("Fetching all cinemas");
        return cinemaRepo.findAll().stream()
                .map(cinemaMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public CinemaDTO getCinemaById(Long id) {
        log.info("Fetching cinema with id: {}", id);
        return cinemaRepo.findById(id).map(cinemaMapper::toDTO).orElse(null);
    }
    @Override
    public CinemaDTO addCinema(CinemaDTO cinema) {
        log.info("Adding new cinema: {}", cinema);
        Cinema cinemaEntity = cinemaMapper.toEntity(cinema);
        Cinema savedCinema = cinemaRepo.save(cinemaEntity);
        return cinemaMapper.toDTO(savedCinema);
    }
    @Override
    public CinemaDTO updateCinema(Long id, CinemaDTO cinema) {
        log.info("Updating cinema with id: {}", id);
        Cinema existingCinema = cinemaRepo.findById(id).orElse(null);
        if (existingCinema != null) {
            existingCinema.setName(cinema.getName());
            existingCinema.setAddress(cinema.getAddress());
            Cinema updatedCinema = cinemaRepo.save(existingCinema);
            return cinemaMapper.toDTO(updatedCinema);
        }

        return null;
    }
    @Override
    public void deleteCinema(Long id) {
        log.info("Deleting cinema with id: {}", id);
        cinemaRepo.deleteById(id);
    }


}
