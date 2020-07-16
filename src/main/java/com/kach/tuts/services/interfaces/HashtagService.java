package com.kach.tuts.services.interfaces;

import com.kach.tuts.domain.Hashtag;

public interface HashtagService {
    void createHashtag(String NameHashtag, Hashtag hashtag);
    boolean deleteHashtag(Hashtag hashtag);
    boolean uptadeHashtag(String NewName, Hashtag hashtag);
    boolean chekHashtag(String ChekName, Hashtag hashtag);
}
