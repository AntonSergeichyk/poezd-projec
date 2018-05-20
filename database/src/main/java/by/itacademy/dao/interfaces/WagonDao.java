package by.itacademy.dao.interfaces;

import by.itacademy.entity.Wagon;

import java.util.List;

public interface WagonDao extends Dao<Long, Wagon> {

    Wagon findByNumber(Integer number);

    List<Wagon> findByTrainName(String trainName);
}
