package com.example.cinnamon_cinema_backend.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private List<String> genres;
    private String duration;
    private String releaseDate;
    private String imageUrl;
}
