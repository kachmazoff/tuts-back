package com.kach.tuts.controllers;

import com.kach.tuts.models.Tutorial;
import com.kach.tuts.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @GetMapping
    public List<Tutorial> getAllTutorials() {
        return tutorialService.getAll();
    }

    @PostMapping
    public ResponseEntity createNewTutorialDraft(@RequestBody Map<String, String> body) {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle(body.get("title"));
        tutorial.setDescription(body.get("setDescription"));

        tutorialService.save(tutorial);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
