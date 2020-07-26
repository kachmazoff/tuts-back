package com.kach.tuts.services.impl;


import com.kach.tuts.dao.TutorialDao;
import com.kach.tuts.domain.Tutorial;
import com.kach.tuts.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {
    private TutorialDao tutorialDao;

    @Autowired
    public void setHashtagDao(TutorialDao tutorialDao) {
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
}
