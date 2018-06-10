package com.itacademy.service.Impl;

import com.itacademy.entity.TypePlace;
import com.itacademy.repository.TypePlaceRepository;
import com.itacademy.service.interfaces.TypePlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypePlaceServiceImpl implements TypePlaceService {

    private final TypePlaceRepository typePlaceRepository;

    @Autowired
    public TypePlaceServiceImpl(TypePlaceRepository typePlaceRepository) {
        this.typePlaceRepository = typePlaceRepository;
    }

    @Override
    public TypePlace save(TypePlace object) {
        return typePlaceRepository.save(object);
    }

    @Override
    public List<TypePlace> findAll() {
        Iterable<TypePlace> result = typePlaceRepository.findAll();
        ArrayList<TypePlace> trains = new ArrayList<>();
        result.forEach(trains::add);
        return trains;
    }

    @Override
    public TypePlace find(Integer id) {
        Optional<TypePlace> typePlace = typePlaceRepository.findById(id);
        return typePlace.orElse(null);
    }

    @Override
    public void update(TypePlace object) {

    }

    @Override
    public void delete(TypePlace object) {
        typePlaceRepository.delete(object);
    }
}
