package com.example.cinnamon_cinema_backend.services;

import com.example.cinnamon_cinema_backend.dtos.TransactionDTO;
import com.example.cinnamon_cinema_backend.entities.Transaction;

import java.util.List;

public interface TransactionService {
    TransactionDTO processTransaction(Long transactionId);

    void cancelTransaction(Long transactionId);

    void refundTransaction(Long transactionId);

    List<TransactionDTO> getAllTransactions();
    TransactionDTO getTransactionById(Long transactionId);

    List<TransactionDTO> getTransactionsByUserId(Long userId);

    TransactionDTO createTransaction(TransactionDTO transaction);
}
