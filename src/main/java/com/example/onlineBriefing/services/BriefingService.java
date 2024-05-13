package com.example.onlineBriefing.services;

import com.example.onlineBriefing.repositories.AnswerStudentRepository;
import com.example.onlineBriefing.repositories.BriefingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BriefingService {

    @Autowired
    private BriefingRepository briefingRepository;
}
