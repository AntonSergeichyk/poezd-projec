package com.itacademy.repository;

import com.itacademy.dto.PlaceDto;
import com.itacademy.entity.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

    List<Place> findAllByWagonIdAndReserved(Serializable wagonId, Boolean reserved);

    @Query("select new com.itacademy.dto.PlaceDto(count(p.number), tp.type) from Place p " +
            "join p.wagon w join p.typePlace tp group by tp.type, w.id having w.id= :wagonId")
    List<PlaceDto> findCountPlaceByTypeByWagonId(@Param("wagonId") Serializable wagonId);

    @Query("select new com.itacademy.dto.PlaceDto (count (p.number), tw.type) from Place p " +
            "join p.wagon w join  w.train t join w.typeWagon tw " +
            "group by tw.type, t.id, p.reserved having t.id= :trainId and p.reserved =:reserwed")
    List<PlaceDto> findCountPlaceByTrainIdByWagonType(@Param("trainId") Serializable trainId, @Param("reserwed") Boolean reserwed);
}
