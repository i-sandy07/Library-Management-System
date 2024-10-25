package com.MinorProject.Student_Library_Management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;
}
