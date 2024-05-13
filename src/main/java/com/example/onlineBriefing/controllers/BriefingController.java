package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.services.BriefingService;
import com.example.onlineBriefing.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class BriefingController {

    @Autowired
    private BriefingService briefingService;

    @GetMapping(value = "/getBriefings/{id_subject}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBriefings(@PathVariable Integer id_subject) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(briefingService.getAllBriefingsByIdSubject(id_subject));
    }

}
