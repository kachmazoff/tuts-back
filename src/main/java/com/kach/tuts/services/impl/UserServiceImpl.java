package com.kach.tuts.services.impl;

import com.kach.tuts.models.User;
import com.kach.tuts.repositories.UserRepository;
import com.kach.tuts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    public void createUser(String login, String password) {
        User newUser = new User();
        newUser.setUsername(login);
//        newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("Not found");
        }
        return user.get();
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        // TODO:
        throw new UnsupportedOperationException("Not implemented, yet");
    }
}
