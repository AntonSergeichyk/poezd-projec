package com.itacademy.repository;

import com.itacademy.entity.Train;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainRepository extends CrudRepository<Train, Long> {

    Optional<Train> findByName(String trainName);
}
