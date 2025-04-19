package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Showtime;
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

    @Override
    public Showtime createShowtime(Showtime showtime) {
        log.info("Creating new showtime: {}", showtime);
        // Implement the logic to save the showtime
        // For example, you can use a repository to save the showtime
        showtimeRepo.save(showtime);
        return showtime;
    }

    @Override
    public Showtime getShowtimeById(Long id) {
        log.info("Fetching showtime with id: {}", id);
        // Implement the logic to fetch a showtime by its ID
        // For example, you can use a repository to find the showtime by its ID
        return showtimeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Showtime> getAllShowtimes() {
        log.info("Fetching all showtimes");
        // Implement the logic to fetch all showtimes
        // For example, you can use a repository to find all showtimes
        return showtimeRepo.findAll();
    }

    @Override
    public Showtime updateShowtime(Long id, Showtime showtime) {
        log.info("Updating showtime with id: {}", id);
        // Implement the logic to update the showtime
        // For example, you can use a repository to find the showtime by its ID and update it
        Showtime existingShowtime = getShowtimeById(id);
        if (existingShowtime != null) {
            existingShowtime.setMovie(showtime.getMovie());
            existingShowtime.setRoom(showtime.getRoom());
            existingShowtime.setStartTime(showtime.getStartTime());
            existingShowtime.setEndTime(showtime.getEndTime());
            showtimeRepo.save(existingShowtime);
        }
        return existingShowtime;
    }

    @Override
    public void deleteShowtime(Long id) {
        log.info("Deleting showtime with id: {}", id);
        // Implement the logic to delete the showtime
        // For example, you can use a repository to delete the showtime by its ID
        showtimeRepo.deleteById(id);
    }

    @Override
    public List<Showtime> getShowtimesByMovieId(Long movieId) {
        log.info("Fetching showtimes for movie with id: {}", movieId);
        // Implement the logic to fetch showtimes by movie ID
        // For example, you can use a repository to find showtimes by movie ID
        return showtimeRepo.findByMovieId(movieId);
    }
}
