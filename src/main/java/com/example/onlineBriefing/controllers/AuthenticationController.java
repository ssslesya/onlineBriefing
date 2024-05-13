package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.models.LoginMoodle;
import com.example.onlineBriefing.repositories.LoginMoodleRepository;
import com.example.onlineBriefing.services.LoginMoodleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class AuthenticationController {
    LoginMoodleService loginMoodleService;
    @PostMapping("/login")
    public ResponseEntity<?> logClient(@RequestBody String login, String status){
        LoginMoodle loginMoodle = new LoginMoodle(login, status);
        return loginMoodleService.auth(loginMoodle);
    }
}
