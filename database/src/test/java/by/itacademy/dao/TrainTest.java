package by.itacademy.dao;

import by.itacademy.dao.impl.TrainDaoImpl;
import by.itacademy.entity.Train;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainTest extends BaseDaoTest {

    private TrainDaoImpl trainDao = TrainDaoImpl.getInstance();

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

    @Test
    public void findByName() {
       Train result = trainDao.findByName("минск-слоним");
        assertThat(result.getNumber(), equalTo(4));
    }
}
