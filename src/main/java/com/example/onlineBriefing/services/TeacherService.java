package com.example.onlineBriefing.services;

import com.example.onlineBriefing.models.Teacher;
import com.example.onlineBriefing.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    public Teacher getTeacherByLogin(Integer login){
        return teacherRepository.findByLogin(login) ;
    }
}
