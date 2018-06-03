package com.itacademy.serviceNew.interfaces;

import com.itacademy.entity.User;

public interface UserService extends BaseService<Long, User> {

    User findByNameAndPassword(String name, String password);
}
