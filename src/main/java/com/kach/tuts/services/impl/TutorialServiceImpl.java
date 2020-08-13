package com.kach.tuts.services.impl;


import com.kach.tuts.dao.TutorialDao;
import com.kach.tuts.domain.Tutorial;
import com.kach.tuts.domain.TutorialStep;
import com.kach.tuts.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {
    private final TutorialDao tutorialDao;

    @Autowired
    public TutorialServiceImpl(TutorialDao tutorialDao) {
        this.tutorialDao = tutorialDao;
    }

    @Override
    public Tutorial save(Tutorial tutorial) {
        return tutorialDao.save(tutorial);
    }

    @Override
    public void update(Tutorial tutorial) {
        tutorialDao.update(tutorial);
    }

    @Override
    public Tutorial getById(Long id) {
        return tutorialDao.getById(id);
    }

    @Override
    public List<Tutorial> getAll() {
        return tutorialDao.getAll();
    }

    @Override
    public void delete(Tutorial hashtag) {
        tutorialDao.delete(hashtag);
    }

    @Override
    public void setTutorialStepList(Tutorial tutorial, List<TutorialStep> tutorialStepList) {
        this.tutorialDao.setTutorialStepList(tutorial, tutorialStepList);
    }

    @Override
    public void addTutorialStep(Tutorial tutorial, TutorialStep tutorialStep) {
        this.tutorialDao.addTutorialStep(tutorial, tutorialStep);
    }

    @Override
    public void deleteTutorialStep(Tutorial tutorial, TutorialStep tutorialStep) {
        this.tutorialDao.deleteTutorialStep(tutorial, tutorialStep);
    }
}
