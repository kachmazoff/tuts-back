package com.kach.tuts.dao;

import com.kach.tuts.dao.interfaces.HashtagDao;
import com.kach.tuts.domain.Hashtag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HashtagDaoImpl implements HashtagDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void create(String nameHashtag){

    }
    @Override
    public void delete(Hashtag hashtag){

    }
    @Override
    public void change(Hashtag hashtag){

    }
}
