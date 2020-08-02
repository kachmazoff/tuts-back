package com.kach.tuts.dao;

import com.kach.tuts.domain.User;

public interface UserDao extends CrudDao<User>{
    void deleteByUsernameAndPassword(String username, String password);
}
