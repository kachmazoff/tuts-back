package com.kach.tuts.services;

import com.kach.tuts.models.Hashtag;

public interface HashtagService extends CrudService<Hashtag> {
    /**
     * Создание нового хэштега
     * @param name - хэштег
     */
    void create(String name);
}
