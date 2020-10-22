package com.kach.tuts.services.impl;

import com.kach.tuts.dto.TutorialStepDTO;
import com.kach.tuts.models.Tutorial;
import com.kach.tuts.repositories.TutorialRepository;
import com.kach.tuts.repositories.TutorialStepRepository;
import com.kach.tuts.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    @Autowired
    TutorialStepRepository tutorialStepRepository;

    @Override
    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public void update(Tutorial tutorial) {
        save(tutorial);
    }

    @Override
    public Tutorial getById(Long id) {
        return tutorialRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Tutorial> getAll() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorialRepository.findAll().forEach(tutorials::add);
        return tutorials;
    }

    @Override
    public void delete(Tutorial tutorial) {
        tutorialRepository.delete(tutorial);
    }

    @Override
    public void delete(Long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public List<TutorialStepDTO> getStepsOfTutorial(Long tutorialId) {
        List<TutorialStepDTO> stepsDto = new ArrayList<>();
        tutorialStepRepository.findAllByTutorial_Id(tutorialId)
            .forEach(tutorialStep -> {
                stepsDto.add(
                        new TutorialStepDTO(tutorialStep.getId(), tutorialStep.getOrderNumber(), tutorialStep.getTitle(), tutorialStep.getBody())
                );
            });
        return stepsDto;
    }
}
