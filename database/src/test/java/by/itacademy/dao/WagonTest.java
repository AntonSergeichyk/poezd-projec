package by.itacademy.dao;

import by.itacademy.entity.Train;
import by.itacademy.entity.TypeWagon;
import by.itacademy.entity.Wagon;
import org.junit.Test;

public class WagonTest extends BaseDaoTest {

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
}
