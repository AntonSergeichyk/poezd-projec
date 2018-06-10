package com.itacademy.repository;

import com.itacademy.entity.Wagon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WagonRepository extends CrudRepository<Wagon, Long> {

    Optional<Wagon> findByNumberAndTrainId(Integer number, Long trainId);

    List<Wagon> findByTrainName(String trainName);
}
