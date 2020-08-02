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
    public User delete(String login, String password) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
