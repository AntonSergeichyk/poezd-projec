package com.itacademy.dao.interfaces;

import com.itacademy.entity.Train;

public interface TrainDao extends Dao<Long, Train> {

    Train findByName(String trainName);
}
