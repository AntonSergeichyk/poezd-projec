package com.itacademy.service;

import com.itacademy.entity.Wagon;
import com.itacademy.service.interfaces.WagonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class WagonServiceTest extends BaseServiceTes {

    @Autowired
    private WagonService wagonService;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", wagonService);
    }

    @Test
    public void findByTrainName() {
        List<Wagon> results = wagonService.findByTrainName("минск-брест");
        assertThat(results, hasSize(4));
    }
}
