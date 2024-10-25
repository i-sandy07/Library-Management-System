package com.MinorProject.Student_Library_Management.Repository;

import com.MinorProject.Student_Library_Management.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
//    writing our own query of method
//    fetching student by name
    @Query(nativeQuery = true,value= "select * from student where name= :val")
    public List<Student> fetchingStudent(String val);
}
