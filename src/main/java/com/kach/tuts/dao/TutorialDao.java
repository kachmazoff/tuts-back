package com.kach.tuts.dao;


import com.kach.tuts.domain.Hashtag;
import com.kach.tuts.domain.Tutorial;

public interface TutorialDao extends CrudDao<Tutorial> {
    void setHashtag(Tutorial tutorial, Hashtag hashtag);
}
