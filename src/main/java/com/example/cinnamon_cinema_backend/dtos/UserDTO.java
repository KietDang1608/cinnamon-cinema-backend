package com.example.cinnamon_cinema_backend.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;

    private Long roleId;
    private String createdAt;
}
