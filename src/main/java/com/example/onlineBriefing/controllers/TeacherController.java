package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.services.AnswerStudentService;
import com.example.onlineBriefing.services.BriefingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class TeacherController {
    @Autowired
    private BriefingService briefingService;
    @Autowired
    private AnswerStudentService answerStudentService;
    @GetMapping("/getTop/{subject}/{group}")
    public ResponseEntity<?> getTopStudents(@PathVariable Integer idSubject,@PathVariable Integer group){
        return ResponseEntity.ok(briefingService.getTopStudents(idSubject, group));
    }
}
