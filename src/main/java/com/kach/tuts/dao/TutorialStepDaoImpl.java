package com.kach.tuts.dao;

import com.kach.tuts.dao.interfaces.TutorialStepDao;
import com.kach.tuts.domain.TutorialStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TutorialStepDaoImpl implements TutorialStepDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TutorialStep save(TutorialStep tutorialStep) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        TutorialStep newTutorialStep = (TutorialStep) session.save(tutorialStep);
        transaction.commit();
        session.close();
        return newTutorialStep;
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
    public TutorialStep getById(int id) {
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


}
