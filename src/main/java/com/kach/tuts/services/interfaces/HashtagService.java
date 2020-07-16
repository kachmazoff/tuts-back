package com.kach.tuts.services.interfaces;

import com.kach.tuts.domain.Hashtag;

public interface HashtagService {
    void createHashtag(String nameHashtag, Hashtag hashtag);
    boolean deleteHashtag(Hashtag hashtag);
    boolean uptadeHashtag(String newName, Hashtag hashtag);
    boolean chekHashtag(String chekName, Hashtag hashtag);
}
