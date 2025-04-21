package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.ShowtimeDTO;
import com.example.cinnamon_cinema_backend.entities.Showtime;
import com.example.cinnamon_cinema_backend.mappers.ShowtimeMapper;
import com.example.cinnamon_cinema_backend.repositories.MovieRepo;
import com.example.cinnamon_cinema_backend.repositories.RoomRepo;
import com.example.cinnamon_cinema_backend.repositories.ShowtimeRepo;
import com.example.cinnamon_cinema_backend.services.ShowtimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShowtimeServiceImp implements ShowtimeService {
    private final ShowtimeRepo showtimeRepo;
    private final MovieRepo movieRepo;
    private final RoomRepo roomRepo;
    private final ShowtimeMapper showtimeMapper;

    @Override
    public ShowtimeDTO createShowtime(ShowtimeDTO showtime) {
        log.info("Creating new showtime: {}", showtime);
        Showtime showtimeEntity = showtimeMapper.toEntity(showtime);
        Showtime savedShowtime = showtimeRepo.save(showtimeEntity);
        return showtimeMapper.toDTO(savedShowtime);
    }

    @Override
    public ShowtimeDTO getShowtimeById(Long id) {
        log.info("Fetching showtime with id: {}", id);
        return showtimeRepo.findById(id)
                .map(showtimeMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<ShowtimeDTO> getAllShowtimes() {
        log.info("Fetching all showtimes");
        return showtimeRepo.findAll().stream()
                .map(showtimeMapper::toDTO)
                .toList();
    }

    @Override
    public ShowtimeDTO updateShowtime(Long id, ShowtimeDTO showtime) {
        log.info("Updating showtime with id: {}", id);
        Showtime existingShowtime = showtimeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
        existingShowtime.setStartTime(showtime.getStartTime());
        existingShowtime.setMovie( movieRepo.findById(showtime.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found")));
        existingShowtime.setEndTime(showtime.getEndTime());
        existingShowtime.setRoom( roomRepo.findById(showtime.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found")));
        Showtime updatedShowtime = showtimeRepo.save(existingShowtime);
        return showtimeMapper.toDTO(updatedShowtime);
    }

    @Override
    public void deleteShowtime(Long id) {
        log.info("Deleting showtime with id: {}", id);
        Showtime showtime = showtimeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
        showtimeRepo.delete(showtime);
        log.info("Deleted showtime with id: {}", id);
    }

    @Override
    public List<ShowtimeDTO> getShowtimesByMovieId(Long movieId) {
        log.info("Fetching showtimes for movie with id: {}", movieId);
        return showtimeRepo.findByMovieId(movieId).stream()
                .map(showtimeMapper::toDTO)
                .toList();
    }
}
