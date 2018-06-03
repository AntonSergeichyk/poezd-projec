package com.itacademy.dao;

import com.itacademy.dao.interfaces.RoleDao;
import com.itacademy.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class RoleTest extends BaseDaoTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", roleDao);
    }

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
