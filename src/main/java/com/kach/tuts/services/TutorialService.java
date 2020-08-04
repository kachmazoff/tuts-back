package com.kach.tuts.services;


import com.kach.tuts.domain.Hashtag;
import com.kach.tuts.domain.Tutorial;

public interface TutorialService extends CrudService<Tutorial> {
    void setHashtag(Tutorial tutorial, Hashtag hashtag);
}
