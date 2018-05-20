package by.itacademy.dao.interfaces;

import by.itacademy.entity.TypeWagon;

import java.util.List;

public interface TypeWagonDao extends Dao<Integer, TypeWagon> {

    List<TypeWagon> findAllByTrainId(Long wagonId);
}
