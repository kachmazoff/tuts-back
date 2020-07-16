package com.kach.tuts.dao.interfaces;

import com.kach.tuts.domain.Hashtag;

public interface HashtagDao {
            void create(String NameHashtag);
            void delete(Hashtag hashtag);
            void change(Hashtag hashtag);
}
