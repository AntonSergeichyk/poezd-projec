package by.itacademy.dao;

import by.itacademy.entity.Role;
import org.junit.Test;

public class RoleTest extends BaseDaoTest {

    @Test
    public void saveRole() {
        Role role = new Role("user");
        save(role);
    }

    @Test
    public void findRole() {
        Role role = new Role("user");
        find(role);
    }
}
