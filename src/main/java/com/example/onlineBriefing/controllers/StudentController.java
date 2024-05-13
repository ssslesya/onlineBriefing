package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.models.Student;
import com.example.onlineBriefing.services.BriefingService;
import com.example.onlineBriefing.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private BriefingService briefingService;

    @GetMapping(value = "/getStudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.findStudentById(id));
    }
//Средний балл по предмету
    @GetMapping("/averageGrade/{idStudent}/{subject}")
    public ResponseEntity<Double> getAverageGradeBySubject(@PathVariable Integer idStudent, @PathVariable Integer subject) {
        double averageGrade = briefingService.calculateAverageGradeBySubject(idStudent, subject);
        return ResponseEntity.ok(averageGrade);
    }


}
