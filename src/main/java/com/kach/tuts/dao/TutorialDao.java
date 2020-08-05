package com.kach.tuts.dao;


import com.kach.tuts.domain.Hashtag;
import com.kach.tuts.domain.Tutorial;

import java.util.List;

public interface TutorialDao extends CrudDao<Tutorial> {
    void setHashtag(Tutorial tutorial, List<Hashtag> hashtags);
}
