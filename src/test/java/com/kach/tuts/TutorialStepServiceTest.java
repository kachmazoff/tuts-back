package com.kach.tuts;

import com.kach.tuts.domain.TutorialStep;
import com.kach.tuts.services.interfaces.TutorialStepService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TutorialStepServiceTest {
    private TutorialStep actualTutorialStep;
    private TutorialStepService tutorialStepService;


    @Autowired
    public void setTutorialStepService(TutorialStepService tutorialStepService) {
        this.tutorialStepService = tutorialStepService;
    }

    @BeforeEach
    public void setUp() {
        actualTutorialStep = new TutorialStep("1", "2");
    }

    @Test
    public void saveTutorialStep() {
        TutorialStep expectedTutorialStep = tutorialStepService.saveTutorialStep(actualTutorialStep);
        Assertions.assertEquals(expectedTutorialStep, actualTutorialStep);
    }

    @Test
    public void updateTutorialStep() {
        actualTutorialStep.setBody("123213");
        actualTutorialStep.setTitle("asd");
        actualTutorialStep.setId(50);

        tutorialStepService.updateTutorialStep(actualTutorialStep);

        Assertions.assertTrue(tutorialStepService.getAllTutorialSteps().contains(actualTutorialStep));
    }

    @Test
    public void deleteTutorialStep() {
        tutorialStepService.saveTutorialStep(actualTutorialStep);
        tutorialStepService.deleteTutorialStep(actualTutorialStep);

        Assertions.assertFalse(tutorialStepService.getAllTutorialSteps().contains(actualTutorialStep));
    }

    @Test
    public void getAllTutorialSteps() {
        List<TutorialStep> tutorialSteps = tutorialStepService.getAllTutorialSteps();

        for (TutorialStep tutorialStep : tutorialSteps) tutorialStepService.deleteTutorialStep(tutorialStep);

        for (TutorialStep tutorialStep : tutorialSteps) tutorialStepService.saveTutorialStep(tutorialStep);

        Assertions.assertEquals(tutorialSteps, tutorialStepService.getAllTutorialSteps());

    }

    @Test
    public void getByIdTutorialStepNotEqual() {
        actualTutorialStep.setBody("123213");
        actualTutorialStep.setTitle("asd");

        Assertions.assertNotEquals(actualTutorialStep, tutorialStepService.getTutorialStepById(3));
    }

    @Test
    public void getByIdTutorialEqual() {
        actualTutorialStep.setId(3);
        tutorialStepService.updateTutorialStep(actualTutorialStep);

        Assertions.assertEquals(actualTutorialStep, tutorialStepService.getTutorialStepById(3));
    }
}
