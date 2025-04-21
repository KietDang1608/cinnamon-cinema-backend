package com.example.cinnamon_cinema_backend.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SeatDTO {
    private Long id;
    private String seatNumber;
    private boolean isAvailable;
    private Long roomId;

}
