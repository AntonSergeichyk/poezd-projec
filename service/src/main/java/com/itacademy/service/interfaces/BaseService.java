package com.itacademy.serviceNew.interfaces;

import com.itacademy.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<PK extends Serializable, T extends BaseEntity<PK>> {

    T save(T object);

    List<T> findAll();

    T find(PK id);

    void update(T object);

    void delete(T object);
}
