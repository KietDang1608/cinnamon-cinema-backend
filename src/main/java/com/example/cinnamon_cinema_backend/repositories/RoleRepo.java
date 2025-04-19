package com.example.cinnamon_cinema_backend.repositories;

import com.example.cinnamon_cinema_backend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    // Custom query methods can be defined here if needed
    // For example, find by name or other attributes
}
