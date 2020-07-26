package com.kach.tuts.dao.impl;

import com.kach.tuts.dao.TutorialDao;
import com.kach.tuts.domain.Tutorial;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TutorialDaoImpl implements TutorialDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Tutorial save(Tutorial tutorial) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tutorial);
        transaction.commit();
        session.close();
        return tutorial;
    }

    @Override
    public void update(Tutorial tutorial) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(tutorial);
        transaction.commit();
        session.close();
    }

    @Override
    public Tutorial getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Tutorial tutorial = session.get(Tutorial.class, id);
        transaction.commit();
        session.close();
        return tutorial;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tutorial> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Tutorial> tutorials = session.createQuery("from Tutorial ").list();
        transaction.commit();
        session.close();
        return tutorials;
    }

    @Override
    public void delete(Tutorial tutorial) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(tutorial);
        transaction.commit();
        session.close();
}
}
