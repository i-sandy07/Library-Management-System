package com.MinorProject.Student_Library_Management.Model;

import com.MinorProject.Student_Library_Management.Enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int card_id;
    @CurrentTimestamp
    private Date card_created_date;
    @UpdateTimestamp
    private Date card_updated_date;
    @Enumerated(value = EnumType.STRING)
    CardStatus card_status;
    @OneToOne
    @JoinColumn
    @JsonBackReference
    private Student student;
    @JsonManagedReference
    @OneToMany(mappedBy ="card",cascade = CascadeType.ALL)
    private List<Book> bookForCard=new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy ="card",cascade = CascadeType.ALL)
    private List<Transactions> transactionsForCard=new ArrayList<>();
}
