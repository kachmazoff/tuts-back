package com.kach.tuts.services.impl;

import com.kach.tuts.models.EntityStatus;
import com.kach.tuts.models.Hashtag;
import com.kach.tuts.repositories.HashtagRepository;
import com.kach.tuts.services.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HashtagServiceImpl implements HashtagService {

    @Autowired
    HashtagRepository hashtagRepository;

    @Override
    public Hashtag save(Hashtag hashtag) {
        return hashtagRepository.save(hashtag);
    }

    @Override
    public void update(Hashtag hashtag) {
        hashtagRepository.save(hashtag);
    }

    @Override
    public Hashtag getById(Long id) {
        Hashtag hashtag = hashtagRepository.findById(id).orElse(null);
        if (hashtag != null && hashtag.getStatus() == EntityStatus.DELETED)
            hashtag = null;
        return hashtag;
    }

    @Override
    public List<Hashtag> getAll() {
        List<Hashtag> result = new ArrayList<>();
        hashtagRepository.findAllByStatus(EntityStatus.ACTIVE).forEach(result::add);
        return result;
    }

    @Override
    public void delete(Hashtag hashtag) {
        hashtag.setStatus(EntityStatus.DELETED);
        hashtagRepository.save(hashtag);
    }

    @Override
    public void delete(Long id) {
        Hashtag hashtag = hashtagRepository.findById(id).orElseThrow();
        delete(hashtag);
    }

    @Override
    public void create(String name) {
        Hashtag newHashtag = new Hashtag(name);
        save(newHashtag);
    }
}
