package com.itacademy.serviceNew.interfaces;

import com.itacademy.entity.Train;

public interface TrainService extends BaseService<Long, Train> {

    Train findByName(String trainName);
}
