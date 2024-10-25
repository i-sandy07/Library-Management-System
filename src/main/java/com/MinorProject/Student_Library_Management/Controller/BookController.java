package com.MinorProject.Student_Library_Management.Controller;

import com.MinorProject.Student_Library_Management.DTO.BookDto;
import com.MinorProject.Student_Library_Management.Model.Book;
import com.MinorProject.Student_Library_Management.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {
    BookService bookService;
    @Autowired
    BookController(BookService bookService){
        this.bookService=bookService;
    }
    @PostMapping("/create")
    public String createBook(@RequestBody BookDto bookDto){
        String result=bookService.save(bookDto);
        return result;
    }
    @GetMapping("/getAll")
    public List<Book> findAll(){
        return bookService.getAll();
    }
    @GetMapping("/get")
    public List<Book> find(@RequestParam("pageno")int pageNo,@RequestParam("pagesize") int pageSize,@RequestParam("using") String sortValue){
        return bookService.get(pageNo,pageSize,sortValue);
    }
    @GetMapping("/getbookbyquantity")
    public List<Book> getBookByName(@RequestParam("bookquantity")int num){
        return bookService.getbookByQuantity(num);
    }
    @GetMapping("/getbookbyname")
    public List<Book> getBookByName(@RequestParam("bookname")String name){
        return bookService.getbookByBookName(name);
    }
}
