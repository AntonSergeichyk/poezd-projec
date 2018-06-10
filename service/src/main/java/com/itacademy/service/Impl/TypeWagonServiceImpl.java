package com.itacademy.service.Impl;

import com.itacademy.entity.TypeWagon;
import com.itacademy.repository.TypeWagonRepository;
import com.itacademy.service.interfaces.TypeWagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeWagonServiceImpl implements TypeWagonService {

    private final TypeWagonRepository typeWagonRepository;

    @Autowired
    public TypeWagonServiceImpl(TypeWagonRepository typeWagonRepository) {
        this.typeWagonRepository = typeWagonRepository;
    }

    @Override
    public TypeWagon save(TypeWagon object) {
        return typeWagonRepository.save(object);
    }

    @Override
    public List<TypeWagon> findAll() {
        Iterable<TypeWagon> result = typeWagonRepository.findAll();
        ArrayList<TypeWagon> typeWagons = new ArrayList<>();
        result.forEach(typeWagons::add);
        return typeWagons;
    }

    @Override
    public TypeWagon find(Integer id) {
        Optional<TypeWagon> typeWagon = typeWagonRepository.findById(id);
        return typeWagon.orElse(null);
    }

    @Override
    public void update(TypeWagon object) {

    }

    @Override
    public void delete(TypeWagon object) {
        typeWagonRepository.delete(object);
    }
}
