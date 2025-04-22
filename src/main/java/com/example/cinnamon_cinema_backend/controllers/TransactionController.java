package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.dtos.TransactionDTO;
import com.example.cinnamon_cinema_backend.entities.Transaction;
import com.example.cinnamon_cinema_backend.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
        TransactionDTO transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByUserId(@PathVariable Long userId) {
        List<TransactionDTO> transactions = transactionService.getTransactionsByUserId(userId);
        return ResponseEntity.ok(transactions);
    }
    @PostMapping
    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionDTO transaction) {
        TransactionDTO createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.status(201).body(createdTransaction);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> processTransaction(@PathVariable Long id) {
        TransactionDTO updatedTransaction = transactionService.processTransaction(id);
        if (updatedTransaction != null) {
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelTransaction(@PathVariable Long id) {
        transactionService.cancelTransaction(id);
        return ResponseEntity.noContent().build();
    }

}
