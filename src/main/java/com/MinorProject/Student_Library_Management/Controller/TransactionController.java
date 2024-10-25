package com.MinorProject.Student_Library_Management.Controller;

import com.MinorProject.Student_Library_Management.DTO.TransactionDto;
import com.MinorProject.Student_Library_Management.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {
    private final TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create")
    public String createTransaction(@RequestBody TransactionDto transactionDto){
        String response=transactionService.save(transactionDto);
        return response;
    }
}
