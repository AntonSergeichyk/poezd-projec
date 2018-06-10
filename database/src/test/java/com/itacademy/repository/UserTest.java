package com.itacademy.repository;

import com.itacademy.entity.Role;
import com.itacademy.entity.User;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class UserTest extends BaseRepositoryTes {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", userRepository);
    }

    @Test
    public void saveUser() {
        Role role = new Role("use");
        User user = new User(role, "Dima", "11111111", "qwerty@gmail.com");
        Role roleId = roleRepository.save(role);
        Assert.assertNotNull("Id is null", roleId.getId());
        User userId = userRepository.save(user);
        Assert.assertNotNull("Id is null", userId.getId());
    }

    @Test
    public void findUser() {
        Iterable<User> users = userRepository.findAll();
        List<User> values = new ArrayList<>();
        users.forEach(values::add);
        final int expectedSize = 3;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
        assertThat(values.get(0).getName(), Matchers.equalTo("Anton"));
    }

    @Test
    public void testFindByNamePassword() {
        Optional<User> user = userRepository.findByNameAndPassword("Andrey", "passw");
        assertTrue(user.isPresent());
        assertThat(user.get().getMailbox(), equalTo("12qwerty@gmail.com"));
    }
}
