package com.MinorProject.Student_Library_Management.DTO;

import com.MinorProject.Student_Library_Management.Enums.TransactionName;
import lombok.Data;

@Data
public class TransactionDto {
    String transactionStatus;
    TransactionName  transactionName;
    int card_id;
    int book_id;
}
