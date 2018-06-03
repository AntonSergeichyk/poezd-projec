package com.itacademy.dao;

import com.itacademy.dao.interfaces.StationDao;
import com.itacademy.entity.Station;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class StationTest extends BaseDaoTest {

    @Autowired
    private StationDao stationDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", stationDao);
    }

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
