package com.kach.tuts.services.impl;

import com.kach.tuts.dao.TutorialStepDao;
import com.kach.tuts.domain.TutorialStep;
import com.kach.tuts.services.TutorialStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialStepServiceImpl implements TutorialStepService {
    private TutorialStepDao tutorialStepDao;

    @Autowired
    public void setTutorialStepDao(TutorialStepDao tutorialStepDao) {
        this.tutorialStepDao = tutorialStepDao;
    }

    @Override
    public TutorialStep save(TutorialStep tutorialStep) {
        return this.tutorialStepDao.save(tutorialStep);
    }

    @Override
    public void update(TutorialStep tutorialStep) {
        this.tutorialStepDao.update(tutorialStep);
    }

    @Override
    public TutorialStep getById(Long id) {
        return this.tutorialStepDao.getById(id);
    }

    @Override
    public List<TutorialStep> getAll() {
        return this.tutorialStepDao.getAll();
    }

    @Override
    public void delete(TutorialStep tutorialStep) {
        this.tutorialStepDao.delete(tutorialStep);
    }
}
