package com.itacademy.repository;

import com.itacademy.entity.TypeWagon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeWagonRepository extends CrudRepository<TypeWagon, Integer> {
}
