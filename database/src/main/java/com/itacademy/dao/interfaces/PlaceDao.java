package by.itacademy.dao.interfaces;

import by.itacademy.dto.PlaceDto;
import by.itacademy.entity.Place;

import java.util.List;

public interface PlaceDao extends Dao<Long, Place> {

    List<Place> findAllFreePlaceByWagonIdAndTrainId(Long wagonId, Long trainId);

    List<PlaceDto> findCountPlaceByWagonId(Long wagonId);
}
