package com.kach.tuts.services;

import com.kach.tuts.dao.interfaces.TutorialStepDao;
import com.kach.tuts.domain.TutorialStep;
import com.kach.tuts.services.interfaces.TutorialStepService;
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
    public TutorialStep saveTutorialStep(TutorialStep tutorialStep) {
        return this.tutorialStepDao.save(tutorialStep);
    }

    @Override
    public void updateTutorialStep(TutorialStep tutorialStep) {
        this.tutorialStepDao.update(tutorialStep);
    }

    @Override
    public TutorialStep getTutorialStepById(int id) {
        return this.tutorialStepDao.getById(id);
    }

    @Override
    public List<TutorialStep> getAllTutorialSteps() {
        return this.tutorialStepDao.getAll();
    }

    @Override
    public void deleteTutorialStep(TutorialStep tutorialStep) {
        this.tutorialStepDao.delete(tutorialStep);
    }
}
