package com.example.onlineBriefing.services;

import com.example.onlineBriefing.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    public ResponseEntity<?> getTeacherByLogin(String login){
        if(teacherRepository.findById_login(login) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacherRepository.findById_login(login)) ;
    }
}
