package com.itacademy.service.Impl;

import com.itacademy.entity.TimeTable;
import com.itacademy.repository.TimeTableRepository;
import com.itacademy.service.interfaces.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepository timeTableRepository;

    @Autowired
    public TimeTableServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public List<TimeTable> findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart(Long stationStartId, Long stationFinishId, LocalDate timeStart, Pageable pageable) {
        return timeTableRepository.findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart(stationStartId, stationFinishId,timeStart,  pageable);
    }

    @Override
    public TimeTable save(TimeTable object) {
        return timeTableRepository.save(object);
    }

    @Override
    public List<TimeTable> findAll() {
        Iterable<TimeTable> result = timeTableRepository.findAll();
        ArrayList<TimeTable> timeTables = new ArrayList<>();
        result.forEach(timeTables::add);
        return timeTables;
    }

    @Override
    public TimeTable find(Long id) {
        Optional<TimeTable> timeTable= timeTableRepository.findById(id);
        return timeTable.orElse(null);
    }

    @Override
    public void update(TimeTable object) {

    }

    @Override
    public void delete(TimeTable object) {
        timeTableRepository.delete(object);
    }
}
