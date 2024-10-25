package com.MinorProject.Student_Library_Management.Controller;

import com.MinorProject.Student_Library_Management.DTO.StudentDto;
import com.MinorProject.Student_Library_Management.Model.Student;
import com.MinorProject.Student_Library_Management.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {
    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    @PostMapping("/create")
    public String createStudent(@RequestBody StudentDto studentDto){
          logger.info("create student method started");
          String result=studentService.create(studentDto);
          return result;
    }
    @GetMapping("/getStudent/{sid}")
    public Student getStudent(@PathVariable("sid") int sId){
        return studentService.getStudent(sId);
    }
    @GetMapping("/getbyName")
    public List<Student> getStudentbyName(@RequestParam("studentname")String name){
        return studentService.getByName(name);
    }
}
