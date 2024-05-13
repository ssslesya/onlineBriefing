package com.example.onlineBriefing.services;

import com.example.onlineBriefing.models.Briefing;
import com.example.onlineBriefing.models.News;
import com.example.onlineBriefing.repositories.AnswerStudentRepository;
import com.example.onlineBriefing.repositories.BriefingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefingService {

    @Autowired
    private BriefingRepository briefingRepository;

    public List<Briefing> getAllBriefingsByIdSubject(Integer idSubject) {
        return briefingRepository.findAllByIdSubject(idSubject);
    }
}
