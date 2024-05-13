package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.models.News;
import com.example.onlineBriefing.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/getNews/{id_profile}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNews(@PathVariable Integer id_profile) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(newsService.getAllNewsByIdProfile(id_profile));
    }



}
