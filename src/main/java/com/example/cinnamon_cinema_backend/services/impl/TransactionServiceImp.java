package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.entities.Transaction;
import com.example.cinnamon_cinema_backend.entities.TransactionStatus;
import com.example.cinnamon_cinema_backend.repositories.TransactionRepo;
import com.example.cinnamon_cinema_backend.repositories.UserRepo;
import com.example.cinnamon_cinema_backend.services.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepo transactionRepo;

    @Override
    public Transaction processTransaction(Long transactionId) {
        log.info("Processing transaction with ID: {}", transactionId);
        // Implement the logic to process the transaction
        // For example, you can use a repository to find the transaction by its ID and update its status
        Transaction transaction = getTransactionById(transactionId);
        if (transaction != null) {
            transaction.setStatus(TransactionStatus.valueOf("Processed"));
            transactionRepo.save(transaction);
        } else {
            log.warn("Transaction with ID: {} not found", transactionId);
        }
        return transaction;
    }

    @Override
    public void cancelTransaction(Long transactionId) {
        log.info("Cancelling transaction with ID: {}", transactionId);
        // Implement the logic to cancel the transaction
        // For example, you can use a repository to find the transaction by its ID and update its status
        Transaction transaction = getTransactionById(transactionId);
        if (transaction != null) {
            transaction.setStatus(TransactionStatus.valueOf("Cancelled"));
            transactionRepo.save(transaction);
        } else {
            log.warn("Transaction with ID: {} not found", transactionId);
        }
    }

    @Override
    public void refundTransaction(Long transactionId) {
        log.info("Refunding transaction with ID: {}", transactionId);
        // Implement the logic to refund the transaction
        // For example, you can use a repository to find the transaction by its ID and update its status
        Transaction transaction = getTransactionById(transactionId);
        if (transaction != null) {
            transaction.setStatus(TransactionStatus.valueOf("Refunded"));
            transactionRepo.save(transaction);
        } else {
            log.warn("Transaction with ID: {} not found", transactionId);
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        log.info("Fetching all transactions");
        // Implement the logic to fetch all transactions
        // For example, you can use a repository to find all transactions
        return transactionRepo.findAll();
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        log.info("Fetching transaction with ID: {}", transactionId);
        // Implement the logic to fetch a transaction by its ID
        // For example, you can use a repository to find the transaction by its ID
        return transactionRepo.findById(transactionId).orElse(null);
    }

    @Override
    public List<Transaction> getTransactionsByUserId(Long userId) {
        log.info("Fetching transactions for user with ID: {}", userId);
        // Implement the logic to fetch transactions by user ID
        // For example, you can use a repository to find transactions by user ID
        return transactionRepo.findByUserId(userId);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        log.info("Creating new transaction: {}", transaction);
        // Implement the logic to create a new transaction
        // For example, you can use a repository to save the transaction
        return transactionRepo.save(transaction);
    }
}
