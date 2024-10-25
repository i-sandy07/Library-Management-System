package com.MinorProject.Student_Library_Management.Converter;

import com.MinorProject.Student_Library_Management.DTO.AuthorDto;
import com.MinorProject.Student_Library_Management.Model.Author;

public class AuthorConverter {
    public static Author convert(AuthorDto authorDto){
        Author author=Author.builder().author_name(authorDto.getAuthorName()).author_age(authorDto.getAge()).build();
        return author;
    }
}
