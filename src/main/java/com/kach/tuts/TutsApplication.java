package com.kach.tuts;

import com.kach.tuts.dao.TutorialStepDaoImpl;
import com.kach.tuts.domain.TutorialStep;
import com.kach.tuts.services.interfaces.TutorialStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutsApplication {
    @Autowired
    TutorialStepDaoImpl dao;

    public static void main(String[] args) {
        SpringApplication.run(TutsApplication.class, args);
    }

}
