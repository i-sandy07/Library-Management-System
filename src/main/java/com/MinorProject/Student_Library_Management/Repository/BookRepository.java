package com.MinorProject.Student_Library_Management.Repository;

import com.MinorProject.Student_Library_Management.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public List<Book> findByQuantity(int num);
    public List<Book> findByBookname(String name);
}
