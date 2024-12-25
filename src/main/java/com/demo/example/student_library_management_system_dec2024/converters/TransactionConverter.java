package com.demo.example.student_library_management_system_dec2024.converters;

import com.demo.example.student_library_management_system_dec2024.model.Transaction;
import com.demo.example.student_library_management_system_dec2024.requestdto.TransactionRequestDto;

public class TransactionConverter {

    public static Transaction convertTransactionRequestDtoToTransaction(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionStatus(transactionRequestDto.getTransactionStatus());
        transaction.setIssueOrReturn(transactionRequestDto.getIssueOrReturn());
        transaction.setFine(transactionRequestDto.getFine());
        transaction.setDueDate(transactionRequestDto.getDueDate());
         return transaction;
    }
}
