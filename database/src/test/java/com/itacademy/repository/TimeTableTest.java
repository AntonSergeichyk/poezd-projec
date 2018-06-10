package com.itacademy.repository;

import com.itacademy.entity.Station;
import com.itacademy.entity.TimeTable;
import com.itacademy.entity.Train;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TimeTableTest extends BaseRepositoryTes {

    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private TimeTableRepository timeTableRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", timeTableRepository);
    }

    @Test
    public void saveTimeTable() {
        Station stationStart = new Station("Минск-Пассажирский");
        Station stationFinish = new Station("Брест-центральный");
        Train train = new Train(701, "Брест-Минск");
        TimeTable timeTable = new TimeTable(stationStart, stationFinish, train, LocalDate.now(), LocalDate.now());

        Station stationStartId = stationRepository.save(stationStart);
        Assert.assertNotNull("Id is Null", stationStartId.getId());
        Station stationFinishId = stationRepository.save(stationFinish);
        Assert.assertNotNull("Id is Null", stationFinishId.getId());
        Train trainId = trainRepository.save(train);
        Assert.assertNotNull("Id is Null", trainId.getId());
        TimeTable timeTableId = timeTableRepository.save(timeTable);
        Assert.assertNotNull("Id is Null", timeTableId.getId());
    }

    @Test
    public void findTimeTable() {
        Iterable<TimeTable> tables = timeTableRepository.findAll();
        List<TimeTable> values = new ArrayList<>();
        tables.forEach(values::add);
        final int expectedSize = 5;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
    }

    @Test
    public void findByStationsAndDate() {
        Iterable<Station> stations = stationRepository.findAll();
        List<Station> values = new ArrayList<>();
        stations.forEach(values::add);
        final int expectedSize = 6;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
        Station stationStart = values.get(0);
        Station stationFinish = values.get(1);
        List<TimeTable> timeTables = timeTableRepository.findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart(stationStart.getId(), stationFinish.getId(),
                LocalDate.of(2018, Month.MAY, 28), PageRequest.of(0, 2));
        final int expectedSize2 = 1;
        assertThat(timeTables, IsCollectionWithSize.hasSize(expectedSize2));
        assertThat(timeTables.get(0).getTrain().getName(), equalTo("минск-брест"));
    }
}
