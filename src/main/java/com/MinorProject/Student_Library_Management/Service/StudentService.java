package com.MinorProject.Student_Library_Management.Service;

import com.MinorProject.Student_Library_Management.Controller.StudentController;
import com.MinorProject.Student_Library_Management.Converter.StudentConverter;
import com.MinorProject.Student_Library_Management.DTO.StudentDto;
import com.MinorProject.Student_Library_Management.Enums.CardStatus;
import com.MinorProject.Student_Library_Management.Model.Card;
import com.MinorProject.Student_Library_Management.Model.Student;
import com.MinorProject.Student_Library_Management.Repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    Logger logger= LoggerFactory.getLogger(StudentService.class);
    StudentRepository studentRepository;
    @Autowired
    StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public String create(StudentDto studentDto){
        logger.info("Create method from Service class started");
        Student student= StudentConverter.convert(studentDto);
        Card card=new Card();
        card.setStudent(student);
        card.setCard_status(CardStatus.ACTIVE);
        student.setCard(card);
        studentRepository.save(student);
        logger.info("method execution completed");
        return "student saved";
    }
    public Student getStudent(int id){
        Student student=studentRepository.findById(id).get();
        return student;
    }
    public List<Student> getByName(String name){
        List<Student> students=studentRepository.fetchingStudent(name);
        return students;
    }
}
