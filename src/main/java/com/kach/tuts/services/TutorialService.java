package com.kach.tuts.services;


import com.kach.tuts.domain.Hashtag;
import com.kach.tuts.domain.Tutorial;

import java.util.List;

public interface TutorialService extends CrudService<Tutorial> {
    void setHashtag(Tutorial tutorial, List<Hashtag> hashtags);
}
