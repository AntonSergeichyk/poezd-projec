package by.itacademy.dao;

import by.itacademy.dao.impl.RoleDaoImpl;
import by.itacademy.entity.Role;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class RoleTest extends BaseDaoTest {

    private RoleDaoImpl roleDao = RoleDaoImpl.getInstance();

    @Test
    public void saveRole() {
        Role role = new Role("user");
        Integer roleId = roleDao.save(role);
        Assert.assertNotNull("Id is null", roleId);
    }

    @Test
    public void findRole() {
        List<Role> roles = roleDao.findAll();
        assertThat(roles, hasSize(2));
        Role role = roles.get(0);
        role = roleDao.find(role.getId());
        assertThat(role.getName(), equalTo("USER"));
    }
}
