package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.UserDTO;
import com.example.cinnamon_cinema_backend.entities.User;
import com.example.cinnamon_cinema_backend.mappers.UserMapper;
import com.example.cinnamon_cinema_backend.repositories.UserRepo;
import com.example.cinnamon_cinema_backend.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp  implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public UserDTO registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepo.save(user);
        log.info("User registered: {}", username);
        return userMapper.toDTO(user);
    }

    @Override
    public void loginUser(String username, String password) {

    }

    @Override
    public void updateUserDetails(Long userId, String newUsername, String newPassword) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(newUsername);
        user.setPassword(newPassword);
        userRepo.save(user);
        log.info("User details updated for: {}", newUsername);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);
        log.info("User deleted: {}", user.getUsername());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("Fetching all users");
        return userRepo.findAll().stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        log.info("Fetched user: {}", user.getUsername());
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepo.findByUsername(username);
        log.info("Fetched user: {}", user.getUsername());
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, User user) {
        log.info("Updating user with ID: {}", id);
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        User updatedUser = userRepo.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }
}
