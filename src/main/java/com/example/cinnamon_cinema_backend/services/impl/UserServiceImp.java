package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.User;
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

    @Override
    public User getUserByUsername(String username) {
        log.info("Fetching user with username: {}", username);
        // Implement the logic to fetch a user by their username
        // For example, you can use a repository to find the user by their username
        return userRepo.findByUsername(username);
    }

    @Override
    public User updateUser(Long id, User user) {
        log.info("Updating user with id: {}", id);
        // Implement the logic to update a user
        // For example, you can use a repository to find the user by their ID and update their details
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            userRepo.save(existingUser);
        }
        return existingUser;
    }

    @Override
    public User registerUser(String username, String password) {
        log.info("Registering user with username: {}", username);
        // Implement the logic to register a new user
        // For example, you can create a new User object and save it to the database
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepo.save(user);
        return user;
    }

    @Override
    public void loginUser(String username, String password) {
        log.info("Logging in user with username: {}", username);
        // Implement the logic to authenticate a user
        // For example, you can check the username and password against the database
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            log.info("User {} logged in successfully", username);
        } else {
            log.warn("Invalid credentials for user {}", username);
        }
    }

    @Override
    public void updateUserDetails(Long userId, String newUsername, String newPassword) {
        log.info("Updating user with id: {}", userId);
        // Implement the logic to update user details
        // For example, you can find the user by ID and update their details
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            user.setUsername(newUsername);
            user.setPassword(newPassword);
            userRepo.save(user);
        } else {
            log.warn("User with id {} not found", userId);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        log.info("Deleting user with id: {}", userId);
        // Implement the logic to delete a user
        // For example, you can delete the user by their ID
        userRepo.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        // Implement the logic to fetch all users
        // For example, you can use a repository to find all users
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        log.info("Fetching user with id: {}", userId);
        // Implement the logic to fetch a user by their ID
        // For example, you can use a repository to find the user by their ID
        return userRepo.findById(userId).orElse(null);
    }
}
