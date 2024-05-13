package com.example.onlineBriefing.services;

import com.example.onlineBriefing.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    public ResponseEntity<?> getQuestionsByIdBriefing(Integer id_briefing){
        if(questionRepository.findByBriefing(id_briefing).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(questionRepository.findByBriefing(id_briefing)) ;
    }
}
