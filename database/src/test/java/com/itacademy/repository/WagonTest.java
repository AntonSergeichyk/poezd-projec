package com.itacademy.repository;

import com.itacademy.entity.Wagon;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class WagonTest extends BaseRepositoryTes {

    @Autowired
    private WagonRepository wagonRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", wagonRepository);
    }

    @Test
    public void findWagon() {
        Iterable<Wagon> wagons = wagonRepository.findAll();
        List<Wagon> values = new ArrayList<>();
        wagons.forEach(values::add);
        final int expectedSize = 16;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
        assertThat(values.get(0).getNumber(), Matchers.equalTo(1));
    }

    @Test
    public void findByTrainName() {
        List<Wagon> results = wagonRepository.findByTrainName("минск-брест");
        assertThat(results, hasSize(4));
    }
}
