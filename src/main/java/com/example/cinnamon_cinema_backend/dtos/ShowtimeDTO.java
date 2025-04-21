package com.example.cinnamon_cinema_backend.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ShowtimeDTO {
    private Long id;
    private String startTime;
    private String endTime;
    private String date;
    private Long movieId;
    private Long roomId;
}
