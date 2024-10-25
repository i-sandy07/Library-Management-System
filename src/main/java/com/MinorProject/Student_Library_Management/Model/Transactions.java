package com.MinorProject.Student_Library_Management.Model;

import com.MinorProject.Student_Library_Management.Enums.TransactionName;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int transaction_id;
    @Enumerated(value = EnumType.STRING)
    TransactionName transaction_name;
    @CurrentTimestamp
    Date trasaction_date;
    Date due_date;
    int fine;
    String transaction_status;
    @JsonBackReference
    @JoinColumn
    @ManyToOne
    Book book;
    @JsonBackReference
    @JoinColumn
    @ManyToOne
    Card card;
}
