package com.kach.tuts.exeption;

public class TutorialNotFoundExeption extends Exception {
    private Long tutorial_id;

    public TutorialNotFoundExeption(long tutorial_id){
       super(String.format("Tutorial is not found id: '%s'",tutorial_id));
    }
}
