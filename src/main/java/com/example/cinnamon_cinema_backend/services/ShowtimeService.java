package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.ShowtimeDTO;
import com.example.cinnamon_cinema_backend.entities.Showtime;

import java.util.List;

public interface ShowtimeService {
    // Define the methods that will be implemented in the service class
    // For example:
    ShowtimeDTO createShowtime(ShowtimeDTO showtime);

    ShowtimeDTO getShowtimeById(Long id);

    List<ShowtimeDTO> getAllShowtimes();

    ShowtimeDTO updateShowtime(Long id, ShowtimeDTO showtime);

    void deleteShowtime(Long id);

    List<ShowtimeDTO> getShowtimesByMovieId(Long movieId);
}
