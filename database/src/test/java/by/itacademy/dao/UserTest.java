package by.itacademy.dao;

import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.junit.Test;

public class UserTest extends BaseDaoTest {

    @Test
    public void saveUser() {
        Role role = new Role("user");
        User user = new User(role, "Anton", "11111111", "qwerty@gmail.com");
        save(role, user);
    }

    @Test
    public void findUser() {
        Role role = new Role("user");
        User user = new User(role, "Anton", "11111111", "qwerty@gmail.com");
        find(role, user);
    }
}
