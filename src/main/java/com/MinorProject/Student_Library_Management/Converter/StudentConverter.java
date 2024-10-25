package com.MinorProject.Student_Library_Management.Converter;

import com.MinorProject.Student_Library_Management.DTO.StudentDto;
import com.MinorProject.Student_Library_Management.Model.Student;

public class StudentConverter {
    public static Student convert(StudentDto studentDto){
        Student student=Student.builder().age(studentDto.getAge()).name(studentDto.getName()).build();
        return student;
    }
}
