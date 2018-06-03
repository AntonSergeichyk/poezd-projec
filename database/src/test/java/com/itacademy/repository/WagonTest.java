package com.itacademy.dao;

import com.itacademy.dao.interfaces.TrainDao;
import com.itacademy.dao.interfaces.TypeWagonDao;
import com.itacademy.dao.interfaces.WagonDao;
import com.itacademy.entity.Train;
import com.itacademy.entity.TypeWagon;
import com.itacademy.entity.Wagon;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class WagonTest extends BaseDaoTest {

    @Autowired
    private WagonDao wagonDao;
    private TypeWagonDao typeWagonDao;
    private TrainDao trainDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", wagonDao);
    }

    @Test
    public void saveWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);

        Integer typeWagonId = typeWagonDao.save(typeWagon);
        Assert.assertNotNull("Id is null", typeWagonId);
        Long trainId = trainDao.save(train);
        Assert.assertNotNull("Id is null", trainId);
        Long wadonId = wagonDao.save(wagon);
        Assert.assertNotNull("Id is null", wadonId);
    }

    @Test
    public void findWagon() {
        List<Wagon> wagons = wagonDao.findAll();
        assertThat(wagons, hasSize(16));
        Wagon wagon = wagons.get(0);
        wagon = wagonDao.find(wagon.getId());
        assertThat(wagon.getNumber(), Matchers.equalTo(1));
    }

    @Test
    public void findByTrainName() {
        List<Wagon> results = wagonDao.findByTrainName("минск-брест");
        assertThat(results, hasSize(4));
    }
}
