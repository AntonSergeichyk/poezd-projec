package by.itacademy.dao;

import by.itacademy.dao.impl.WagonDaoImpl;
import by.itacademy.entity.Train;
import by.itacademy.entity.TypeWagon;
import by.itacademy.entity.Wagon;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class WagonTest extends BaseDaoTest {

    private WagonDaoImpl wagonDao = WagonDaoImpl.getInstance();

    @Test
    public void saveWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        save(typeWagon, train, wagon);
    }

    @Test
    public void findWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        find(typeWagon, train, wagon);
    }

    @Test
    public void findByTrainName() {
        List<Wagon> results = wagonDao.findByTrainName("минск-брест");
        assertThat(results, hasSize(4));
    }
}
