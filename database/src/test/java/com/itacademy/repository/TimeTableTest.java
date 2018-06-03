package com.itacademy.dao;

import com.itacademy.dao.interfaces.StationDao;
import com.itacademy.dao.interfaces.TimeTableDao;
import com.itacademy.dao.interfaces.TrainDao;
import com.itacademy.entity.Station;
import com.itacademy.entity.TimeTable;
import com.itacademy.entity.Train;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TimeTableTest extends BaseDaoTest {

    @Autowired
    private StationDao stationDao;
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private TimeTableDao timeTableDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", timeTableDao);
    }

    @Test
    public void saveTimeTable() {
        Station stationStart = new Station("Минск-Пассажирский");
        Station stationFinish = new Station("Брест-центральный");
        Train train = new Train(701, "Брест-Минск");
        TimeTable timeTable = new TimeTable(stationStart, stationFinish, train, LocalDate.now(), LocalDate.now());

        Long stationStartId = stationDao.save(stationStart);
        Assert.assertNotNull("Id is Null", stationStartId);
        Long stationFinishId = stationDao.save(stationFinish);
        Assert.assertNotNull("Id is Null", stationFinishId);
        Long trainId = trainDao.save(train);
        Assert.assertNotNull("Id is Null", trainId);
        Long timeTableId = timeTableDao.save(timeTable);
        Assert.assertNotNull("Id is Null", timeTableId);
    }

    @Test
    public void findTimeTable() {
        List<TimeTable> tables = timeTableDao.findAll();
        assertThat(tables, hasSize(5));
        TimeTable timeTable = tables.get(0);
        timeTable = timeTableDao.find(timeTable.getId());
        assertThat(timeTable.getTrain().getName(), equalTo("минск-брест"));
    }

    @Test
    public void findByStationsAndDate() {
        List<Station> stations = stationDao.findAll();
        assertThat(stations, hasSize(6));
        Station stationStart = stations.get(0);
        Station stationFinish = stations.get(1);
        List<TimeTable> timeTables = timeTableDao.findByStationsAndDate(stationStart.getId(), stationFinish.getId(),
                LocalDate.of(2018, Month.MAY, 28), 0, 5);
        assertThat(timeTables.get(0).getTrain().getName(), equalTo("минск-брест"));
    }
}
