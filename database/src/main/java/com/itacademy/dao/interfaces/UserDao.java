package by.itacademy.dao.interfaces;

import by.itacademy.entity.User;

import java.util.List;

public interface UserDao extends Dao<Long, User> {

    List<User> findByNamePassword(String name, String password);
}
