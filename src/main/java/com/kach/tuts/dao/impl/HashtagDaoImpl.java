package com.kach.tuts.dao.impl;

import com.kach.tuts.dao.HashtagDao;
import com.kach.tuts.domain.Hashtag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HashtagDaoImpl implements HashtagDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public HashtagDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Hashtag save(Hashtag hashtag) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(hashtag);
        transaction.commit();
        session.close();
        return hashtag;
    }

    @Override
    public void update(Hashtag hashtag) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(hashtag);
        transaction.commit();
        session.close();
    }

    @Override
    public Hashtag getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Hashtag hashtag = session.get(Hashtag.class, id);
        transaction.commit();
        session.close();
        return hashtag;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hashtag> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Hashtag> hashtags = session.createQuery("from Hashtag ").list();
        transaction.commit();
        session.close();
        return hashtags;
    }

    @Override
    public void delete(Hashtag hashtag) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(hashtag);
        transaction.commit();
        session.close();
    }
}
