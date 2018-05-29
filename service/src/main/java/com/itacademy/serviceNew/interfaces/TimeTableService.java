package com.itacademy.dao.interfaces;

import com.itacademy.entity.TimeTable;

import java.time.LocalDate;
import java.util.List;

public interface TimeTableDao extends Dao<Long, TimeTable> {

    List<TimeTable> findByStationsAndDate(Long startStationId, Long finishStationId, LocalDate date, Integer limit, Integer offset);
}
