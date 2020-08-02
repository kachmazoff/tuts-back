package com.kach.tuts.services;

import com.kach.tuts.domain.User;

public interface UserService extends CrudService<User>{
    User save(String login, String password);
    void delete(String login, String password);
}
