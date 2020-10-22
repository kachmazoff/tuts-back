package com.kach.tuts.services.impl;

import com.kach.tuts.dto.TutorialStepDTO;
import com.kach.tuts.models.EntityStatus;
import com.kach.tuts.models.Tutorial;
import com.kach.tuts.models.TutorialStep;
import com.kach.tuts.repositories.TutorialStepRepository;
import com.kach.tuts.services.TutorialStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorialStepServiceImpl implements TutorialStepService {
    @Autowired
    TutorialStepRepository tutorialStepRepository;

    @Override
    public TutorialStep save(TutorialStep tutorialStep) {
        return tutorialStepRepository.save(tutorialStep);
    }

    @Override
    public void update(TutorialStep tutorialStep) {
        tutorialStepRepository.save(tutorialStep);
    }

    @Override
    public TutorialStep getById(Long id) {
        TutorialStep tutorialStep = tutorialStepRepository.findById(id).orElse(null);
        if (tutorialStep != null && tutorialStep.getStatus() == EntityStatus.DELETED) {
            tutorialStep = null;
        }

        return tutorialStep;
    }

    @Override
    public List<TutorialStep> getAll() {
        List<TutorialStep> tutorialSteps = new ArrayList<>();
        tutorialStepRepository.findAllByStatus(EntityStatus.ACTIVE).forEach(tutorialSteps::add);
        return tutorialSteps;
    }

    @Override
    public void delete(TutorialStep tutorialStep) {
        tutorialStep.setStatus(EntityStatus.DELETED);
        tutorialStepRepository.save(tutorialStep);
    }

    @Override
    public void delete(Long id) {
        TutorialStep tutorialStep = tutorialStepRepository.findById(id).orElseThrow();
        delete(tutorialStep);
    }

    @Override
    public TutorialStep create(String title, String body) {
        TutorialStep tutorialStep = new TutorialStep(title, body);
        return tutorialStepRepository.save(tutorialStep);
    }

    @Override
    public TutorialStep create(Tutorial tutorial, TutorialStepDTO tutorialStepDTO) {
        TutorialStep tutorialStep = new TutorialStep();

        tutorialStep.setTitle(tutorialStepDTO.getTitle());
        tutorialStep.setBody(tutorialStepDTO.getBody());
        tutorialStep.setOrderNumber(tutorialStepDTO.getIndex());
        tutorialStep.setTutorial(tutorial);

        return tutorialStepRepository.save(tutorialStep);
    }
}
