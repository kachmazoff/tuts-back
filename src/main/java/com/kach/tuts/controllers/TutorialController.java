package com.kach.tuts.controllers;

import com.kach.tuts.dto.TutorialPreviewDTO;
import com.kach.tuts.dto.TutorialStepDTO;
import com.kach.tuts.models.Tutorial;
import com.kach.tuts.models.TutorialStep;
import com.kach.tuts.models.User;
import com.kach.tuts.services.AuthService;
import com.kach.tuts.services.TutorialService;
import com.kach.tuts.services.TutorialStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @Autowired
    TutorialStepService tutorialStepService;

    @Autowired
    AuthService authService;

    @GetMapping
    public List<TutorialPreviewDTO> getAllTutorials() {
        List<TutorialPreviewDTO> tutorialPreviewDTOList = new ArrayList<>();
        tutorialService.getAll().forEach(tutorial -> { tutorialPreviewDTOList.add(new TutorialPreviewDTO(tutorial)); });
        return tutorialPreviewDTOList;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public TutorialPreviewDTO createNewTutorialDraft(@RequestBody Map<String, Object> body) {
        User author = authService.getActiveUser();

        Tutorial tutorial = new Tutorial();
        tutorial.setTitle((String) body.get("title"));
        tutorial.setDescription((String) body.get("description"));
        tutorial.setAuthor(author);

        if (body.containsKey("steps")) {
            List<TutorialStepDTO> steps = (List<TutorialStepDTO>) body.get("steps");
//            List<Map<String, String>> steps = (List<Map<String, String>>) body.get("steps");
            List<TutorialStep> tutorialSteps = new ArrayList<>();
//            for (int i = 0; i < steps.size(); i++) {
//                Map<String, String> stepMap = steps.get(i);
//                TutorialStepDTO dto = new dto(stepMap.get())
//                TutorialStep createdStep = tutorialStepService.create(dto);
//                tutorialSteps.add(createdStep);
//            steps.forEach(tutorialStepDTO -> {
//                tutorialSteps.add(tutorialStepService.create(tutorialStepDTO));
//            });

            tutorial.setSteps(tutorialSteps);
        }
//            tutorialService.update(tutorial);


        Tutorial createdTutorial = tutorialService.save(tutorial);
        return new TutorialPreviewDTO(createdTutorial);
    }

    @GetMapping("/{id}")
    public TutorialPreviewDTO getTutorial(@PathVariable("id") Long id) {
        Tutorial tutorial = tutorialService.getById(id);
        return new TutorialPreviewDTO(tutorial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTutorial(@PathVariable("id") Long id) {
        tutorialService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}/steps")
    public List<TutorialStepDTO> getTutorialSteps(@PathVariable("id") Long tutorialId) {
        return tutorialService.getStepsOfTutorial(tutorialId);
    }

    @PostMapping("/{id}/steps")
    public ResponseEntity createTutorialSteps(@PathVariable("id") Long tutorialId, @RequestBody List<TutorialStepDTO> steps) {
        Tutorial tutorial = tutorialService.getById(tutorialId);

        List<TutorialStep> tutorialSteps = new ArrayList<>();
        steps.forEach(tutorialStepDTO -> {
            if (tutorialStepDTO.getId() != null) {
                TutorialStep tutorialStep = new TutorialStep();
                tutorialStep.setId(tutorialStepDTO.getId());
                tutorialSteps.add(tutorialStep);
            } else {
                tutorialSteps.add(tutorialStepService.create(tutorial, tutorialStepDTO));
            }
        });

//        Tutorial tutorial = tutorialService.getById(tutorialId);
//        tutorial.setSteps(tutorialSteps);
//        tutorialService.update(tutorial);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
