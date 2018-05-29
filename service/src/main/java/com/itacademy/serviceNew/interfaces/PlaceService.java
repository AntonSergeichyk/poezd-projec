package com.itacademy.dao.interfaces;

import com.itacademy.dto.PlaceDto;
import com.itacademy.entity.Place;

import java.util.List;

public interface PlaceDao extends Dao<Long, Place> {

    List<Place> findAllFreePlaceByWagonIdAndTrainId(Long wagonId, Long trainId);

    List<PlaceDto> findCountPlaceByWagonId(Long wagonId);
}
