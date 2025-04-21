package com.example.cinnamon_cinema_backend.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class TicketSeatDTO {
    private Long id;
    private Long ticketId;
    private Long seatId;
    private int price;

}
