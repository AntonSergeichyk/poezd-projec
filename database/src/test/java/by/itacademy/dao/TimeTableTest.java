package by.itacademy.dao;

import by.itacademy.entity.Station;
import by.itacademy.entity.TimeTable;
import by.itacademy.entity.Train;
import org.junit.Test;

import java.time.LocalDate;

public class TimeTableTest extends BaseDaoTest {

    @Test
    public void saveTimeTable() {
        Station stationStart = new Station("Минск-Пассажирский");
        Station stationFinish = new Station("Брест-центральный");
        Train train = new Train(701, "Брест-Минск");
        TimeTable timeTable = new TimeTable(stationStart, stationFinish, train, LocalDate.now(), LocalDate.now());

        save(stationStart, stationFinish, train, timeTable);
    }

    @Test
    public void findTimeTable() {
        Station stationStart = new Station("Минск-Пассажирский");
        Station stationFinish = new Station("Брест-центральный");
        Train train = new Train(701, "Брест-Минск");
        TimeTable timeTable = new TimeTable(stationStart, stationFinish, train, LocalDate.now(), LocalDate.now());

        find(stationStart, stationFinish, train, timeTable);
    }
}
