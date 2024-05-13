package com.example.onlineBriefing.services;

import com.example.onlineBriefing.models.News;
import com.example.onlineBriefing.models.Subject;
import com.example.onlineBriefing.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjectsByIdProfile(Integer idProfile) {
        return subjectRepository.findAllByIdProfile(idProfile);
    }

}
