package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.services.NewsService;
import com.example.onlineBriefing.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class QuestionController {
    @Autowired
    private QuestionService questionServiceService;
    @GetMapping("/questions/{id_briefing}")
    public ResponseEntity<?> getQuestions(@PathVariable Integer id_briefing){
        return questionServiceService.getQuestionsByIdBriefing(id_briefing);
    }
}
