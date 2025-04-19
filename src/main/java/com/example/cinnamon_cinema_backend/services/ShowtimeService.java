package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Showtime;

import java.util.List;

public interface ShowtimeService {
    // Define the methods that will be implemented in the service class
    // For example:
    Showtime createShowtime(Showtime showtime);

    Showtime getShowtimeById(Long id);

    List<Showtime> getAllShowtimes();

    Showtime updateShowtime(Long id, Showtime showtime);

    void deleteShowtime(Long id);

    List<Showtime> getShowtimesByMovieId(Long movieId);
}
