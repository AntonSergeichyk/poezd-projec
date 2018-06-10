package com.itacademy.service;

import com.itacademy.entity.Station;
import com.itacademy.entity.TimeTable;
import com.itacademy.service.interfaces.StationService;
import com.itacademy.service.interfaces.TimeTableService;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TimeTableServiceTest extends BaseServiceTes {

    @Autowired
    private StationService stationService;
    @Autowired
    private TimeTableService timeTableService;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", timeTableService);
    }

    @Test
    public void findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart() {
        List<Station> stations = stationService.findAll();
        final int expectedSize = 6;
        assertThat(stations, IsCollectionWithSize.hasSize(expectedSize));
        Station stationStart = stations.get(0);
        Station stationFinish = stations.get(1);
        List<TimeTable> timeTables = timeTableService.findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart(stationStart.getId(), stationFinish.getId(),
                LocalDateTime.of(2018, Month.MAY, 28, 0, 0), PageRequest.of(0, 2));
        assertThat(timeTables.get(0).getTrain().getName(), equalTo("минск-брест"));
    }
}
