package com.itacademy.dao;

import com.itacademy.dao.interfaces.TrainDao;
import com.itacademy.dao.interfaces.TypeWagonDao;
import com.itacademy.entity.TypeWagon;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TypeWagonTest extends BaseDaoTest {

    @Autowired
    TypeWagonDao typeWagonDao;
    @Autowired
    TrainDao trainDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", typeWagonDao);
    }

    @Test
    public void saveWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        Integer typeWagonId = typeWagonDao.save(typeWagon);
        Assert.assertNotNull("Id is null", typeWagonId);
    }

    @Test
    public void findWagon() {
        List<TypeWagon> typeWagons = typeWagonDao.findAll();
        assertThat(typeWagons, hasSize(4));
        TypeWagon typeWagon = typeWagons.get(0);
        typeWagon = typeWagonDao.find(typeWagon.getId());
        assertThat(typeWagon.getType(), Matchers.equalTo("плацкартный"));
    }

    @Test
    public void findAllByTrainId() {
        Long trainId = trainDao.findByName("минск-брест").getId();
        List<TypeWagon> results = typeWagonDao.findAllByTrainId(trainId);
        assertThat(results, hasSize(4));
    }
}
