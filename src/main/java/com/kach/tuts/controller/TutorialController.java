package com.kach.tuts.controller;

import com.kach.tuts.dao.impl.TutorialDaoImpl;
import com.kach.tuts.domain.Tutorial;
import com.kach.tuts.domain.TutorialStep;
import com.kach.tuts.exeption.TutorialNotFoundExeption;
import com.kach.tuts.exeption.TutorialStepNotFoundExeption;
import com.kach.tuts.services.impl.TutorialServiceImpl;
import com.kach.tuts.services.impl.TutorialStepServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TutorialController {

    @Autowired
    TutorialServiceImpl tutorialService;

    @Autowired
    TutorialStepServiceImpl tutorialStepService;

    //Получение всеъ туториалов
    @GetMapping("/tutorial/alltutorials")
    public List<Tutorial> getAllTutorials(){ return tutorialService.getAll(); }

    //Получение одного туториала
    @GetMapping("/tutorial/{id}")
    public Tutorial getTutorialById(@PathVariable(value = "id") Long tutorial_id) throws TutorialNotFoundExeption {
        return tutorialService.getById(tutorial_id);
               //.orElseThrow(() -> new TutorialNotFoundExeption(tutorial_id));  не работает, пишет что такого нету в туториале
    }

    //Обновление туториала
    @PutMapping("/tutorial/newTutorial")
    public void updateTutorial(Tutorial tutorial) { tutorialService.update(tutorial);}

    //Удаление туториала
    @DeleteMapping()
    public void  deleteTutorial(Tutorial tutorial){ tutorialService.delete(tutorial);}

    //Получение шага туториала по его id
    @GetMapping("/tutorial/tutorialStep/{id}")
    public TutorialStep getTutorialStep(@PathVariable(value = "id") Long tutoroalStep_id) throws TutorialStepNotFoundExeption{
        return tutorialStepService.getById(tutoroalStep_id);
    }

    //Удаление шага туториала
    @DeleteMapping()
    public void deleteTutorialStep(TutorialStep tutorialStep){tutorialStepService.delete(tutorialStep);}

    //Обновление шага туториала
    @PutMapping("/tutorialStep/newTutorialStep")
    public void uptadeTutorialStep(TutorialStep tutorialStep){ tutorialStepService.update(tutorialStep);}

    //Добавление шага туториала, добавить привязку к туториалу!
    @PostMapping("/tutorial/newTutorialStep")
    public void createTutorialStep(TutorialStep tutorialStep){ tutorialStepService.save(tutorialStep);}

    //Создание черновика туториала или нового?
    @PostMapping("/tutorial/newTutorial")
    public void createTutorial(Tutorial tutorial){ tutorialService.save(tutorial);}
}
