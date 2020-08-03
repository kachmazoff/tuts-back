package com.kach.tuts.dao.impl;

import com.kach.tuts.dao.TutorialStepDao;
import com.kach.tuts.domain.TutorialStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TutorialStepDaoImpl implements TutorialStepDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public TutorialStepDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TutorialStep save(TutorialStep tutorialStep) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tutorialStep);
        transaction.commit();
        session.close();
        return tutorialStep;
    }

    @Override
    public void update(TutorialStep tutorialStep) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(tutorialStep);
        transaction.commit();
        session.close();
    }

    @Override
    public TutorialStep getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        TutorialStep tutorialStep = session.get(TutorialStep.class, id);
        transaction.commit();
        session.close();
        return tutorialStep;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TutorialStep> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<TutorialStep> tutorialSteps = session.createQuery("from TutorialStep").list();
        transaction.commit();
        session.close();
        return tutorialSteps;
    }

    @Override
    public void delete(TutorialStep tutorialStep) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(tutorialStep);
        transaction.commit();
        session.close();
    }
}
