package com.itacademy.dao.interfaces;

import com.itacademy.entity.TypePlace;

import java.util.List;

public interface TypePlaceDao extends Dao<Integer, TypePlace> {

    List<TypePlace> findAllByWagonIdAndTrainId(Long wagonId, Long trainId);
}
