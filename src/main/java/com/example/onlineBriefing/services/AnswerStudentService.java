package com.example.onlineBriefing.services;

import com.example.onlineBriefing.repositories.AnswerStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerStudentService {

    @Autowired
    private AnswerStudentRepository answerStudentRepository;
}
