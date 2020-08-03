package com.kach.tuts.dao.impl;

import com.kach.tuts.dao.UserDao;
import com.kach.tuts.domain.EntityStatus;
import com.kach.tuts.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public void delete(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update User set status = :status" +
                " where username = :username");
        query.setParameter("status", EntityStatus.DELETED);
        query.setParameter("username", user.getUsername());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteByUsernameAndPassword(String username, String password) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update User set status = :status" +
                " where username = :username and password = :password");
        query.setParameter("status", EntityStatus.DELETED);
        query.setParameter("username", username);
        query.setParameter("password", password);
        query.executeUpdate();
        transaction.commit();
        ;
        session.close();
    }
}
