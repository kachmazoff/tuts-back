package com.kach.tuts.exeption;

public class TutorialStepNotFoundExeption extends Exception{
    private Long tutorialStep_id;
    public TutorialStepNotFoundExeption(Long tutorialStep_id){
        super(String.format("TutorialStep is not found id: '%s'",tutorialStep_id));
    }

}
