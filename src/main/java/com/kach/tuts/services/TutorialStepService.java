package com.kach.tuts.services;

import com.kach.tuts.models.TutorialStep;

public interface TutorialStepService extends CrudService<TutorialStep> {
    void create(String title, String body);
}
