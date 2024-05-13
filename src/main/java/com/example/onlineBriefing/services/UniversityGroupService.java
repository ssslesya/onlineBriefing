package com.example.onlineBriefing.services;

import com.example.onlineBriefing.repositories.UniversityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityGroupService {

    @Autowired
    private UniversityGroupRepository universityGroupRepository;
}
