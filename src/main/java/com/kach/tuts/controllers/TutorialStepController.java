package com.kach.tuts.controllers;

import com.kach.tuts.models.TutorialStep;
import com.kach.tuts.services.TutorialStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/steps")
public class TutorialStepController {
    @Autowired
    TutorialStepService tutorialStepService;

    @GetMapping
    List<TutorialStep> getAllSteps() {
        return tutorialStepService.getAll();
    }

    @PostMapping
    ResponseEntity createStep(@RequestBody Map<String, String> body) {
        // TODO: create DTO
        tutorialStepService.create(body.get("title"), body.get("body"));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteTutorialStep(@PathVariable("id") Long id) {
        tutorialStepService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
