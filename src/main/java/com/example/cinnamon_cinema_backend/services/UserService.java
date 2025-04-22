package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.UserDTO;
import com.example.cinnamon_cinema_backend.entities.User;

import java.util.List;

public interface UserService {
    // Define the methods that will be implemented in the service class
    UserDTO registerUser(String username, String password);
    void loginUser(String username, String password);
    void updateUserDetails(Long userId, String newUsername, String newPassword);
    void deleteUser(Long userId);

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long userId);

    UserDTO getUserByUsername(String username);

    UserDTO updateUser(Long id, UserDTO user);
    // Add more methods as needed for user-related operations
}
