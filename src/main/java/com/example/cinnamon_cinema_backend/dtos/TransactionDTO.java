package com.example.cinnamon_cinema_backend.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class TransactionDTO {
    private Long id;
    private String createdAt;
    private int totalPrice;
    private String status;
    private Long ticketId;
    private Long userId;
}
