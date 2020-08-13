package com.kach.tuts.services;


import com.kach.tuts.domain.Tutorial;
import com.kach.tuts.domain.TutorialStep;

import java.util.List;

public interface TutorialService extends CrudService<Tutorial> {
    void setTutorialStepList(Tutorial tutorial, List<TutorialStep> tutorialStepList);
    void addTutorialStep(Tutorial tutorial, TutorialStep tutorialStep);
    void deleteTutorialStep(Tutorial tutorial, TutorialStep tutorialStep);
}
