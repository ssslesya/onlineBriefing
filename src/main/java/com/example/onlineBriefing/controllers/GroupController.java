package com.example.onlineBriefing.controllers;

import com.example.onlineBriefing.models.UniversityGroup;
import com.example.onlineBriefing.services.UniversityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/briefing")
public class GroupController {

    @Autowired
    private UniversityGroupService universityGroupService;

    @GetMapping("/findGroup")
    public ResponseEntity<Integer> findGroupId(
            @RequestParam Integer idProfile,
            @RequestParam Integer yearBegin,
            @RequestParam String number) {

        Optional<UniversityGroup> group = universityGroupService
                .findGroupByProfileYearAndNumber(idProfile, yearBegin, number);

        return group
                .map(universityGroup -> ResponseEntity.ok(universityGroup.getId()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
