package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Genre;

import java.util.List;

public interface GenreService {
    // Define methods for genre-related operations
    // For example, addGenre, getAllGenres, getGenreById, etc.
    // These methods will be implemented in the GenreServiceImpl class

    Genre addGenre(Genre genre);
    Genre updateGenre(Long genreId, Genre genreName);
    void deleteGenre(Long genreId);
    List<Genre> getAllGenres();
    Genre getGenreById(Long genreId);
}
