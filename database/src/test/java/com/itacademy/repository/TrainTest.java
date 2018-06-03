package com.itacademy.dao;

import com.itacademy.dao.interfaces.TrainDao;
import com.itacademy.entity.Train;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TrainTest extends BaseDaoTest {

    @Autowired
    private TrainDao trainDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", trainDao);
    }

    @Test
    public void saveTrain() {
        Train train = new Train(701, "Брест-Минск");
        Long trainId = trainDao.save(train);
        Assert.assertNotNull("Id is null", trainId);
    }

    @Test
    public void findTrain() {
        List<Train> trains = trainDao.findAll();
        assertThat(trains, hasSize(5));
        Train train = trains.get(0);
        train = trainDao.find(train.getId());
        assertThat(train.getName(), Matchers.equalTo("минск-брест"));
    }

    @Test
    public void findByName() {
        Train result = trainDao.findByName("минск-слоним");
        assertThat(result.getNumber(), equalTo(4));
    }
}
