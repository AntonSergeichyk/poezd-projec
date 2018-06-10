package com.itacademy.service.interfaces;

import com.itacademy.dto.PlaceDto;
import com.itacademy.entity.Place;

import java.io.Serializable;
import java.util.List;

public interface PlaceService extends BaseService<Long, Place> {

    List<Place> findAllByWagonIdAndReserved(Serializable wagonId, Boolean reserved);

    List<PlaceDto> findCountPlaceByTypeByWagonId(Serializable wagonId);

    List<PlaceDto> findCountPlaceByTrainIdByWagonType(Serializable trainId, Boolean reserwed);
}
