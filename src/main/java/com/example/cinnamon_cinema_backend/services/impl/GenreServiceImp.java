package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Genre;
import com.example.cinnamon_cinema_backend.repositories.GenreRepo;
import com.example.cinnamon_cinema_backend.services.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImp implements GenreService {

    private final GenreRepo genreRepo;

    @Override
    public List<Genre> getAllGenres() {
        log.info("Fetching all genres");
        return genreRepo.findAll();
    }
    @Override
    public Genre getGenreById(Long id) {
        log.info("Fetching genre with id: {}", id);
        return genreRepo.findById(id).orElse(null);
    }
    @Override
    public Genre addGenre(Genre genre) {
        log.info("Creating new genre: {}", genre);
        return genreRepo.save(genre);
    }

    @Override
    public Genre updateGenre(Long genreId, Genre genre) {
        log.info("Updating genre with id: {}", genreId);
        Genre existingGenre = getGenreById(genreId);
        if (existingGenre != null) {
            existingGenre.setName(genre.getName());
            genreRepo.save(existingGenre);
        }
        return existingGenre;
    }
    @Override
    public void deleteGenre(Long genreId) {
        log.info("Deleting genre with id: {}", genreId);
        genreRepo.deleteById(genreId);
    }

}
