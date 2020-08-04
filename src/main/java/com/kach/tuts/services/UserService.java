package com.kach.tuts.services;

import com.kach.tuts.domain.User;

public interface UserService extends CrudService<User>{
    User save(String username, String password);
    void delete(String username, String password);
    User getByUsername(String username);
}
