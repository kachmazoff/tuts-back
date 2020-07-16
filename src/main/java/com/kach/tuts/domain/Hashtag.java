package com.kach.tuts.domain;

import org.yaml.snakeyaml.error.MarkedYAMLException;

public class Hashtag {
    private String name;
    public Hashtag(String name){
       this.name=name;
    }
    public Hashtag(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       if (name.length()<128 | name.length()>0) {
           this.name = name;
       } else {
           throw new IllegalArgumentException();
       }

    }
}
