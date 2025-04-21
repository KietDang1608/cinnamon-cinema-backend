package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.GenreDTO;
import com.example.cinnamon_cinema_backend.entities.Genre;

import java.util.List;

public interface GenreService {
    // Define methods for genre-related operations
    // For example, addGenre, getAllGenres, getGenreById, etc.
    // These methods will be implemented in the GenreServiceImpl class


    GenreDTO addGenre(GenreDTO genre);
    GenreDTO updateGenre(Long genreId, GenreDTO genreDTO);
    void deleteGenre(Long genreId);
    List<GenreDTO> getAllGenres();
    GenreDTO getGenreById(Long genreId);
}
