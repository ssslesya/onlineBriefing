package com.example.onlineBriefing.services;

import com.example.onlineBriefing.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public ResponseEntity<?> getStudentByLogin(String login){
        if(studentRepository.findById_login(login) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRepository.findById_login(login)) ;
    }
}
