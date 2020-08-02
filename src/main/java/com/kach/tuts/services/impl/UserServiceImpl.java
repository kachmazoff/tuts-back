package com.kach.tuts.services.impl;

import com.kach.tuts.dao.UserDao;
import com.kach.tuts.domain.User;
import com.kach.tuts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User save(String login, String password) {
        User toSave = new User(login, password);
        return userDao.save(toSave);
    }

    @Override
    public void delete(String login, String password) {
        userDao.deleteByUsernameAndPassword(login, password);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
