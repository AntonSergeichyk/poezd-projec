package com.itacademy.service;

import com.itacademy.entity.Train;
import com.itacademy.service.interfaces.TrainService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TrainServiceTest extends BaseServiceTes {

    @Autowired
    private TrainService trainService;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", trainService);
    }

    @Test
    public void findByName() {
        Train result = trainService.findByName("минск-слоним");
        assertThat(result.getNumber(), equalTo(4));
    }
}
