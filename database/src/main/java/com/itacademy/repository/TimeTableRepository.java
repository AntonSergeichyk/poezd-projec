package com.itacademy.repository;

import com.itacademy.entity.TimeTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TimeTableRepository extends CrudRepository<TimeTable, Long> {

    List<TimeTable> findAllByStationStartIdAndStationFinishIdAndTimeStartAfterOrderByTimeStart(
            Long stationStart_id, Long stationFinish_id, LocalDateTime timeStart, Pageable pageable);
}
