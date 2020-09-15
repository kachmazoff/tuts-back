package com.kach.tuts.services;

import com.kach.tuts.dto.TutorialStepDTO;
import com.kach.tuts.models.Tutorial;
import com.kach.tuts.models.TutorialStep;

public interface TutorialStepService extends CrudService<TutorialStep> {
    TutorialStep create(String title, String body);
    TutorialStep create(Tutorial tutorial, TutorialStepDTO tutorialStepDTO);
}
