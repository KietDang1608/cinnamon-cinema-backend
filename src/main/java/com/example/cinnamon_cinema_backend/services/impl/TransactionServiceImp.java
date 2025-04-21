package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.TransactionDTO;
import com.example.cinnamon_cinema_backend.entities.Transaction;
import com.example.cinnamon_cinema_backend.entities.TransactionStatus;
import com.example.cinnamon_cinema_backend.mappers.TransactionMapper;
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
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDTO processTransaction(Long transactionId) {
        TransactionDTO transaction = transactionRepo.findById(transactionId)
                .map(transactionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setStatus(TransactionStatus.SUCCESS.name());
        transactionRepo.save(transactionMapper.toEntity(transaction));
        log.info("Transaction processed: {}", transaction);
        return transaction;
    }

    @Override
    public void cancelTransaction(Long transactionId) {
        TransactionDTO transaction = transactionRepo.findById(transactionId)
                .map(transactionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setStatus(TransactionStatus.FAILED.name());
        transactionRepo.save(transactionMapper.toEntity(transaction));
        log.info("Transaction processed: {}", transaction);

    }

    @Override
    public void refundTransaction(Long transactionId) {

    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        log.info("Fetching all transactions");
        return transactionRepo.findAll().stream()
                .map(transactionMapper::toDTO)
                .toList();
    }

    @Override
    public TransactionDTO getTransactionById(Long transactionId) {
        TransactionDTO transaction = transactionRepo.findById(transactionId)
                .map(transactionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        log.info("Transaction found: {}", transaction);
        return transaction;
    }

    @Override
    public List<TransactionDTO> getTransactionsByUserId(Long userId) {
        log.info("Fetching transactions for user with ID: {}", userId);
        return transactionRepo.findByUserId(userId).stream()
                .map(transactionMapper::toDTO)
                .toList();
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transaction) {
        log.info("Creating new transaction: {}", transaction);
        Transaction transactionEntity = transactionMapper.toEntity(transaction);
        Transaction savedTransaction = transactionRepo.save(transactionEntity);
        return transactionMapper.toDTO(savedTransaction);
        
    }
}
