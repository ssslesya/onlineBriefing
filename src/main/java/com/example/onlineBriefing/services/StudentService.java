package com.example.onlineBriefing.services;

import com.example.onlineBriefing.models.Student;
import com.example.onlineBriefing.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public ResponseEntity<?> getStudentByLogin(Integer login){
        if(studentRepository.findByLogin(login) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRepository.findByLogin(login)) ;
    }

    public Optional<Student> findStudentById(Integer id) {
        return studentRepository.findById(id);
    }


}
