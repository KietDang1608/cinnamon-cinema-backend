package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.GenreDTO;
import com.example.cinnamon_cinema_backend.entities.Genre;
import com.example.cinnamon_cinema_backend.mappers.GenreMapper;
import com.example.cinnamon_cinema_backend.repositories.GenreRepo;
import com.example.cinnamon_cinema_backend.services.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImp implements GenreService {

    private final GenreRepo genreRepo;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDTO> getAllGenres() {
        log.info("Fetching all genres");

        return genreRepo.findAll().stream()
                .map(genreMapper::toDTO)
                .collect((Collectors.toList()));
    }

    @Override
    public GenreDTO addGenre(GenreDTO genre) {
        log.info("Adding new genre: {}", genre.getName());
        Genre genreEntity = genreMapper.toEntity(genre);
        Genre savedGenre = genreRepo.save(genreEntity);
        return genreMapper.toDTO(savedGenre);
    }

    @Override
    public GenreDTO updateGenre(Long genreId, GenreDTO genreDTO) {
        log.info("Updating genre with ID: {}", genreId);
        Genre genreEntity = genreRepo.findById(genreId)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genreEntity.setName(genreDTO.getName());
        Genre updatedGenre = genreRepo.save(genreEntity);
        return genreMapper.toDTO(updatedGenre);
    }

    @Override
    public void deleteGenre(Long genreId) {
        log.info("Deleting genre with ID: {}", genreId);
        Genre genreEntity = genreRepo.findById(genreId)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genreRepo.delete(genreEntity);
        log.info("Deleted genre with ID: {}", genreId);
    }

    @Override
    public GenreDTO getGenreById(Long genreId) {
        log.info("Fetching genre with ID: {}", genreId);
        Genre genreEntity = genreRepo.findById(genreId)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        return genreMapper.toDTO(genreEntity);
    }
}
