package com.itacademy.serviceNew.interfaces;

import com.itacademy.entity.Wagon;

import java.util.List;

public interface WagonService extends BaseService<Long, Wagon> {

    Wagon findByNumberAndTrainId(Integer number, Long trainId);

    List<Wagon> findByTrainName(String trainName);
}
