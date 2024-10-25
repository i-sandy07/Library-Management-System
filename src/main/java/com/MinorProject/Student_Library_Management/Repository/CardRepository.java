package com.MinorProject.Student_Library_Management.Repository;

import com.MinorProject.Student_Library_Management.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
