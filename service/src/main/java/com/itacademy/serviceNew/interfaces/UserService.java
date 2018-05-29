package com.itacademy.dao.interfaces;

import com.itacademy.entity.User;

import java.util.List;

public interface UserDao extends Dao<Long, User> {

    List<User> findByNamePassword(String name, String password);
}
