package by.itacademy.dao;

import by.itacademy.dao.impl.TrainDaoImpl;
import by.itacademy.dao.impl.TypeWagonDaoImpl;
import by.itacademy.entity.TypeWagon;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TypeWagonTest extends BaseDaoTest {

    private TypeWagonDaoImpl typeWagonDao = TypeWagonDaoImpl.getInstance();
    private TrainDaoImpl trainDao = TrainDaoImpl.getInstance();

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
