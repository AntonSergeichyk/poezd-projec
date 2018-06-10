package com.itacademy.repository;

import com.itacademy.entity.Role;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class RoleTest extends BaseRepositoryTes {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", roleRepository);
    }

    @Test
    public void saveRole() {
        Role role = new Role("user");
        Role roleId = roleRepository.save(role);
        Assert.assertNotNull("Id is null", roleId.getId());
    }

    @Test
    public void findRole() {
        Iterable<Role> roles = roleRepository.findAll();
        List<Role> values = new ArrayList<>();
        roles.forEach(values::add);
        final int expectedSize = 2;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
    }
}
