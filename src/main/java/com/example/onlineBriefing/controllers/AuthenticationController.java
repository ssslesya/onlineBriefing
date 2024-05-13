package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.models.LoginMoodle;
import com.example.onlineBriefing.services.LoginMoodleService;
import com.example.onlineBriefing.services.StudentService;
import com.example.onlineBriefing.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class AuthenticationController {
    @Autowired
    LoginMoodleService loginMoodleService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @PostMapping("/login") //Здесь выводится LoginMoodle
    public ResponseEntity<?> logClient(@RequestBody String login, String status){
        LoginMoodle loginMoodle = new LoginMoodle(login, status);
        return loginMoodleService.auth(loginMoodle);
    }
    @PostMapping("/auth")//Здесь мы отправляем LoginMoodle
    public ResponseEntity<?> getStudentByLogin(@PathVariable LoginMoodle loginMoodle){
        if (Objects.equals(loginMoodle.getStatus(), "teacher")){
            return teacherService.getTeacherByLogin(loginMoodle.getId());
        }
        else if (Objects.equals(loginMoodle.getStatus(), "student")) {
            return studentService.getStudentByLogin(loginMoodle.getId());
        }
        return ResponseEntity.notFound().build();
    }

}
