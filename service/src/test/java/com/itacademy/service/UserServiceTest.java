package com.itacademy.service;

import com.itacademy.entity.User;
import com.itacademy.service.interfaces.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class UserServiceTest extends BaseServiceTes {

    @Autowired
    private UserService userService;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", userService);
    }

    @Test
    public void findByNameAndPassword() {
        User user = userService.findByNameAndPassword("Andrey", "passw");
        assertThat(user.getMailbox(), equalTo("12qwerty@gmail.com"));
    }
}
