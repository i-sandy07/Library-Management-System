package com.MinorProject.Student_Library_Management.Service;

import com.MinorProject.Student_Library_Management.Converter.AuthorConverter;
import com.MinorProject.Student_Library_Management.DTO.AuthorDto;
import com.MinorProject.Student_Library_Management.Model.Author;
import com.MinorProject.Student_Library_Management.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    AuthorRepository authorRepository;
    @Autowired
    AuthorService(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }
    public String saveAuthor(AuthorDto authorDto){
        Author author= AuthorConverter.convert(authorDto);
        authorRepository.save(author);
        return "author saved successfully";
    }
    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
