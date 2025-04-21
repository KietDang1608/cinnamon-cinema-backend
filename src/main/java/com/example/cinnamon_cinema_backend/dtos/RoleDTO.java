package com.example.cinnamon_cinema_backend.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class RoleDTO {
    private Long id;
    private String name;
}
