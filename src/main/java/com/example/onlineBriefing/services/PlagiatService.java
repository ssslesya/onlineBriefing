package com.example.onlineBriefing.services;

import com.example.onlineBriefing.repositories.PlagiatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlagiatService {

    @Autowired
    private PlagiatRepository plagiatRepository;
}
