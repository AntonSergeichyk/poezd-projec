package com.itacademy.dao.interfaces;

import com.itacademy.entity.TypeWagon;

import java.util.List;

public interface TypeWagonDao extends Dao<Integer, TypeWagon> {

    List<TypeWagon> findAllByTrainId(Long wagonId);
}
