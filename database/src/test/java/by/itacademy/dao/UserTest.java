package by.itacademy.dao;

import by.itacademy.dao.impl.RoleDaoImpl;
import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class UserTest extends BaseDaoTest {

    private UserDaoImpl userDao = UserDaoImpl.getInstance();
    private RoleDaoImpl roleDao = RoleDaoImpl.getInstance();

    @Test
    public void saveUser() {
        Role role = new Role("use");
        User user = new User(role, "Dima", "11111111", "qwerty@gmail.com");
        Integer roleId = roleDao.save(role);
        Assert.assertNotNull("Id is null", roleId);
        Long userId = userDao.save(user);
        Assert.assertNotNull("Id is null", userId);
    }

    @Test
    public void findUser() {
        List<User> users = userDao.findAll();
        assertThat(users, hasSize(3));
        User user = users.get(0);
        user = userDao.find(user.getId());
        assertThat(user.getName(), Matchers.equalTo("Anton"));
    }

    @Test
    public void testFindByNamePassword() {
        List<User> results = userDao.findByNamePassword("Andrey", "passw");
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getMailbox(), equalTo("12qwerty@gmail.com"));
    }
}
