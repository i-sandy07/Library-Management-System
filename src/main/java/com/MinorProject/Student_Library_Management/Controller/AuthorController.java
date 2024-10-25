package com.MinorProject.Student_Library_Management.Controller;

import com.MinorProject.Student_Library_Management.DTO.AuthorDto;
import com.MinorProject.Student_Library_Management.Model.Author;
import com.MinorProject.Student_Library_Management.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author/api")
public class AuthorController {
    AuthorService authorService;
    @Autowired
    AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }
    @PostMapping("/create")
    public String saveAuthor(@RequestBody AuthorDto authorDto){
       String result=authorService.saveAuthor(authorDto);
       return result;
    }
    @GetMapping("/findAll")
    public List<Author> findAll(){
        List<Author> response=authorService.findAll();
        return response;
    }
}
