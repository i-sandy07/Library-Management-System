package com.MinorProject.Student_Library_Management.DTO;

import com.MinorProject.Student_Library_Management.Enums.Genre;
import lombok.Data;

@Data
public class BookDto {
    String bookName;
    int quantity;
    Genre genre;
    int authorId;
}
