package com.MinorProject.Student_Library_Management.Service;

import com.MinorProject.Student_Library_Management.Converter.BookConverter;
import com.MinorProject.Student_Library_Management.DTO.BookDto;
import com.MinorProject.Student_Library_Management.Model.Author;
import com.MinorProject.Student_Library_Management.Model.Book;
import com.MinorProject.Student_Library_Management.Repository.AuthorRepository;
import com.MinorProject.Student_Library_Management.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public String save(BookDto bookDto){
        Book book= BookConverter.convert(bookDto);
        Optional<Author> authorOptional=authorRepository.findById(bookDto.getAuthorId());
        book.setAuthor(authorOptional.get());
        bookRepository.save(book);
        return "Book saved successfully";
    }
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    public List<Book> get(int pageNo,int pageSize,String sortValue){
        Page<Book> books =bookRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortValue).ascending()));
        List<Book> response=new ArrayList<>();
        for(Book book:books){
            response.add(book);
        }
        return response;
    }
    public List<Book> getbookByQuantity(int num){
        return bookRepository.findByQuantity(num);
    }
    public List<Book> getbookByBookName(String name){
        return bookRepository.findByBookname(name);
    }
}

