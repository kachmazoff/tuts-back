package com.kach.tuts.services.impl;

import com.kach.tuts.dao.UserDao;
import com.kach.tuts.domain.EntityStatus;
import com.kach.tuts.domain.User;
import com.kach.tuts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(String username, String password) {
        User toSave = new User(username, passwordEncoder.encode(password));
        toSave.setStatus(EntityStatus.ACTIVE);
        return userDao.save(toSave);
    }

    @Override
    public void delete(String username, String password) {
        userDao.deleteByUsernameAndPassword(username, password);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(EntityStatus.ACTIVE);
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
