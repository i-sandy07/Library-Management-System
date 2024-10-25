package com.MinorProject.Student_Library_Management.Model;

import com.MinorProject.Student_Library_Management.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    @Column(nullable = false)
    String bookname;
    @Column(nullable = false)
    private int quantity;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Author author;
    @JsonManagedReference
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions>transactionByBook=new ArrayList<>();
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Card card;
}
