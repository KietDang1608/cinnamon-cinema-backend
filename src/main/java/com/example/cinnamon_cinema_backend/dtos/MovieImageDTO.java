package com.example.cinnamon_cinema_backend.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MovieImageDTO {
    private Long id;
    private String imageUrl;
    private Long movieId;

}
