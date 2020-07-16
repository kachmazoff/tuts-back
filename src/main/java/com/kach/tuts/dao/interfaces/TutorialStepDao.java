package com.kach.tuts.dao.interfaces;

import com.kach.tuts.domain.TutorialStep;

import java.util.List;


public interface TutorialStepDao {
    TutorialStep save(TutorialStep tutorialStep);
    void update(TutorialStep tutorialStep);
    TutorialStep getById(int id);
    List<TutorialStep> getAll();
    void delete(TutorialStep tutorialStep);
}
