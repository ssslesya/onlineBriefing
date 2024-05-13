package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


}
