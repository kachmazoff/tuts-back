package com.kach.tuts.services.impl;

import com.kach.tuts.dao.HashtagDao;
import com.kach.tuts.domain.Hashtag;
import com.kach.tuts.services.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashtagServiceImpl implements HashtagService {
    private final HashtagDao hashtagDao;

    @Autowired
    public HashtagServiceImpl(HashtagDao hashtagDao) {
        this.hashtagDao = hashtagDao;
    }

    @Override
    public Hashtag save(Hashtag hashtag) {
        return hashtagDao.save(hashtag);
    }

    @Override
    public void update(Hashtag hashtag) {
        hashtagDao.update(hashtag);
    }

    @Override
    public Hashtag getById(Long id) {
        return hashtagDao.getById(id);
    }

    @Override
    public List<Hashtag> getAll() {
        return hashtagDao.getAll();
    }

    @Override
    public void delete(Hashtag hashtag) {
        hashtagDao.delete(hashtag);
    }
}
