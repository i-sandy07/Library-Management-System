package com.MinorProject.Student_Library_Management.DTO;

import com.MinorProject.Student_Library_Management.Model.Card;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class StudentDto {
    private String name;
    private int age;
}
