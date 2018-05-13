package by.itacademy.service;

import by.itacademy.dao.UserDao;
import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public User findUser() {
        return UserDao.getInstance().find();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
