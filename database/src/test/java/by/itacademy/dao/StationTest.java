package by.itacademy.dao;

import by.itacademy.dao.impl.StationDaoImpl;
import by.itacademy.entity.Station;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class StationTest extends BaseDaoTest {

    private StationDaoImpl stationDao = StationDaoImpl.getInstance();

    @Test
    public void saveStation() {
        Station station = new Station("Минск-Пассажирский");
        Long stationId = stationDao.save(station);
        Assert.assertNotNull("Id is null", stationId);
    }

    @Test
    public void findStation() {
        List<Station> stations = stationDao.findAll();
        assertThat(stations, hasSize(6));
        Station station = stations.get(0);
        station = stationDao.find(station.getId());
        assertThat(station.getName(), equalTo("minsk"));
    }
}
