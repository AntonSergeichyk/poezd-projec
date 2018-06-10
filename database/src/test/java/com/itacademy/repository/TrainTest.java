package com.itacademy.repository;

import com.itacademy.entity.Train;
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

public class TrainTest extends BaseRepositoryTes {

    @Autowired
    private TrainRepository trainRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", trainRepository);
    }

    @Test
    public void saveTrain() {
        Train train = new Train(701, "Брест-Минск");
        Train trainId = trainRepository.save(train);
        Assert.assertNotNull("Id is null", trainId.getId());
    }

    @Test
    public void findTrain() {
        Iterable<Train> trains = trainRepository.findAll();
        List<Train> values = new ArrayList<>();
        trains.forEach(values::add);
        final int expectedSize = 5;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
        assertThat(values.get(0).getName(), Matchers.equalTo("минск-брест"));
    }

    @Test
    public void findByName() {
        Optional<Train> result = trainRepository.findByName("минск-слоним");
        assertTrue(result.isPresent());
        assertThat(result.get().getNumber(), equalTo(4));
    }
}
