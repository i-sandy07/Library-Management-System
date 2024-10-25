package com.MinorProject.Student_Library_Management.Repository;

import com.MinorProject.Student_Library_Management.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
}
