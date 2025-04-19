package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.entities.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction processTransaction(Long transactionId);

    void cancelTransaction(Long transactionId);

    void refundTransaction(Long transactionId);

    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Long transactionId);

    List<Transaction> getTransactionsByUserId(Long userId);

    Transaction createTransaction(Transaction transaction);
}
