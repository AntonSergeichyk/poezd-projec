package by.itacademy.service;

import by.itacademy.dao.impl.TimeTableDaoImpl;
import by.itacademy.entity.TimeTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeTableService {

    private static final TimeTableService INSTANCE = new TimeTableService();

    public List<TimeTable> findByStationsAndDate(Long startStationId, Long finishStationId, LocalDate date, Integer limit, Integer offset) {
        return TimeTableDaoImpl.getInstance().findAll();
    }

    public static TimeTableService getInstance() {
        return INSTANCE;
    }
}
