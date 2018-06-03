package com.itacademy.serviceNew.interfaces;

import com.itacademy.entity.TimeTable;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface TimeTableService extends BaseService<Long, TimeTable> {

    List<TimeTable> findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart(Long stationStart_id, Long stationFinish_id, LocalDate timeStart, Pageable pageable);
}
