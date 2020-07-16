package com.kach.tuts.services.interfaces;

import com.kach.tuts.domain.TutorialStep;

import java.util.List;

public interface TutorialStepService {
    TutorialStep saveTutorialStep(TutorialStep tutorialStep);
    void updateTutorialStep(TutorialStep tutorialStep);
    TutorialStep getTutorialStepById(int id);
    List<TutorialStep> getAllTutorialSteps();
}
