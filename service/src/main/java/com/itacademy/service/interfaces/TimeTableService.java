package com.itacademy.service.interfaces;

import com.itacademy.entity.TimeTable;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeTableService extends BaseService<Long, TimeTable> {

    List<TimeTable> findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart(
            Long stationStart_id, Long stationFinish_id, LocalDateTime timeStart, Pageable pageable);
}
