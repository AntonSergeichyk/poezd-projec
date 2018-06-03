package com.itacademy.repository;

import com.itacademy.entity.TypePlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePlaceRepository extends CrudRepository<TypePlace, Integer> {
}
