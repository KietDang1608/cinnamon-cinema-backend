package com.example.cinnamon_cinema_backend.repositories;

import com.example.cinnamon_cinema_backend.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);
    // Custom query methods can be defined here if needed
    // For example, find by name or other attributes
}
