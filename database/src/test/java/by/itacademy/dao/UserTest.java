package by.itacademy.dao;

import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class UserTest extends BaseDaoTest {

    private UserDaoImpl userDao = UserDaoImpl.getInstance();

    @Test
    public void saveUser() {
        Role role = new Role("use");
        User user = new User(role, "Dima", "11111111", "qwerty@gmail.com");
        save(role, user);
    }

    @Test
    public void findUser() {
        Role role = new Role("use");
        User user = new User(role, "Anton", "11111111", "qwerty@gmail.com");
        find(role, user);
        System.out.println();
    }

    @Test
    public void testFindByNamePassword() {
        List<User> results = userDao.findByNamePassword("Andrey", "passw");
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getMailbox(), equalTo("12qwerty@gmail.com"));
    }
}
