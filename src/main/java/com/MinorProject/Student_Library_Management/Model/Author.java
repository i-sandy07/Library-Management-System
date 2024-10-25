package com.MinorProject.Student_Library_Management.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;
    @Column(nullable = false)
    private String author_name;
    private int author_age;
    @JsonManagedReference
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksbyAuthor=new ArrayList<>();
}
