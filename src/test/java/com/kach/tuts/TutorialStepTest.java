package com.kach.tuts;

import com.kach.tuts.domain.TutorialStep;
import com.kach.tuts.services.interfaces.TutorialStepService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TutorialStepTest {
    private TutorialStepService tutorialStepService;

    @Autowired
    public void setTutorialStepService(TutorialStepService tutorialStepService) {
        this.tutorialStepService = tutorialStepService;
    }

    @Test
    public void addTutorialStep() {
        TutorialStep tutorialStep = new TutorialStep("1", "2");
        Assert.assertEquals(tutorialStep, this.tutorialStepService.saveTutorialStep(tutorialStep));
    }
}
