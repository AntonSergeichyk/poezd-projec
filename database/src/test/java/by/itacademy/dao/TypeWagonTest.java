package by.itacademy.dao;

import by.itacademy.dao.impl.TrainDaoImpl;
import by.itacademy.dao.impl.TypeWagonDaoImpl;
import by.itacademy.entity.TypeWagon;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TypeWagonTest extends BaseDaoTest {

    private TypeWagonDaoImpl wagonDao = TypeWagonDaoImpl.getInstance();
    private TrainDaoImpl trainDao = TrainDaoImpl.getInstance();
    @Test
    public void saveWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        save(typeWagon);
    }

    @Test
    public void findWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        find(typeWagon);
    }

    @Test
    public void findAllByTrainId() {
        Long trainId = trainDao.findByName("минск-брест").getId();
        List<TypeWagon> results = wagonDao.findAllByTrainId(trainId);
        assertThat(results, hasSize(4));
    }
}
