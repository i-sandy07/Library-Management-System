package com.MinorProject.Student_Library_Management.Converter;

import com.MinorProject.Student_Library_Management.DTO.TransactionDto;
import com.MinorProject.Student_Library_Management.Model.Transactions;

public class TransactionConverter {
    public static Transactions convert(TransactionDto transactionDto){
        Transactions transaction=Transactions.builder().transaction_name(transactionDto.getTransactionName()).transaction_status(transactionDto.getTransactionStatus()).build();
        return transaction;
    }
}
