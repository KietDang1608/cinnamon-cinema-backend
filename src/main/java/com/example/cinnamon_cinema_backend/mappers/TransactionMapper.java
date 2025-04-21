package com.example.cinnamon_cinema_backend.mappers;

import com.example.cinnamon_cinema_backend.dtos.TransactionDTO;
import com.example.cinnamon_cinema_backend.entities.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDTO toDTO (Transaction transaction);
    Transaction toEntity (TransactionDTO transactionDTO);
}
