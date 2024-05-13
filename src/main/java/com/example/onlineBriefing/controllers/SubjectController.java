package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.services.NewsService;
import com.example.onlineBriefing.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = "/getSubjects/{id_profile}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSubjects(@PathVariable Integer id_prof) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(subjectService.getAllSubjectsByIdProfile(id_prof));
    }

}
