package by.itacademy.dao;

import by.itacademy.entity.Station;
import org.junit.Test;

public class StationTest extends BaseDaoTest {

    @Test
    public void saveStation() {
        Station station = new Station("Минск-Пассажирский");
        save(station);
    }

    @Test
    public void findStation() {
        Station station = new Station("Минск-Пассажирский");
        find(station);
    }
}
