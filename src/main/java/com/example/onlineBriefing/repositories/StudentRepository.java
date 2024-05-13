package com.example.onlineBriefing.repositories;

import com.example.onlineBriefing.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByLogin(Integer idLogin);
    Optional<Student> findById(Integer id);
}
