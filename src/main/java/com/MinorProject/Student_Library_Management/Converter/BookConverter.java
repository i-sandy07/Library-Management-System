package com.MinorProject.Student_Library_Management.Converter;

import com.MinorProject.Student_Library_Management.DTO.BookDto;
import com.MinorProject.Student_Library_Management.Model.Book;

public class BookConverter {
    public static Book convert(BookDto bookDto){
        Book book=Book.builder().bookname(bookDto.getBookName()).genre(bookDto.getGenre()).quantity(bookDto.getQuantity()).build();
        return book;
    }
}
