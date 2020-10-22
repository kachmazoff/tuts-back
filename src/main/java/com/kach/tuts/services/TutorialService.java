package com.kach.tuts.services;

import com.kach.tuts.dto.TutorialStepDTO;
import com.kach.tuts.models.Tutorial;

import java.util.List;

public interface TutorialService extends CrudService<Tutorial> {
    List<TutorialStepDTO> getStepsOfTutorial(Long tutorialId);
}
