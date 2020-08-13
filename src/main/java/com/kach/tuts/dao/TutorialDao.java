package com.kach.tuts.dao;


import com.kach.tuts.domain.Tutorial;
import com.kach.tuts.domain.TutorialStep;

import java.util.List;

public interface TutorialDao extends CrudDao<Tutorial> {
    void setTutorialStepList(Tutorial tutorial, List<TutorialStep> tutorialStepList);
    void addTutorialStep(Tutorial tutorial, TutorialStep tutorialStep);
    void deleteTutorialStep(Tutorial tutorial, TutorialStep tutorialStep);
}
