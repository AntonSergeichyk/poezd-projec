package by.itacademy.dao;

import by.itacademy.entity.Train;
import org.junit.Test;

public class TrainTest extends BaseDaoTest {

    @Test
    public void saveTrain() {
        Train train = new Train(701, "Брест-Минск");
        save(train);
    }

    @Test
    public void findTrain() {
        Train train = new Train(701, "Брест-Минск");
        find(train);
    }
}
