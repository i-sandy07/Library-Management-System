package com.MinorProject.Student_Library_Management.Service;

import com.MinorProject.Student_Library_Management.Converter.TransactionConverter;
import com.MinorProject.Student_Library_Management.DTO.TransactionDto;
import com.MinorProject.Student_Library_Management.Enums.TransactionName;
import com.MinorProject.Student_Library_Management.Model.Book;
import com.MinorProject.Student_Library_Management.Model.Card;
import com.MinorProject.Student_Library_Management.Model.Transactions;
import com.MinorProject.Student_Library_Management.Repository.BookRepository;
import com.MinorProject.Student_Library_Management.Repository.CardRepository;
import com.MinorProject.Student_Library_Management.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public String save(TransactionDto transactionDto) {
        Transactions transaction = TransactionConverter.convert(transactionDto);
        Book book = bookRepository.findById(transactionDto.getBook_id()).get();
        Card card = cardRepository.findById(transactionDto.getCard_id()).get();
        double fine = 0.0;
        if (transactionDto.getTransactionName().equals(TransactionName.PURCHASE)) {
            transaction.setBook(book);
            transaction.setCard(card);
            Date currentDate = new Date();
            transaction.setTrasaction_date(currentDate);
            LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            localDateTime = localDateTime.plusDays(7);
            Date dueDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            transaction.setDue_date(dueDate);
            book.setCard(card);
            transactionRepository.save(transaction);
            return "Book Purchased successfully";
        }
        return "";
    }
}
