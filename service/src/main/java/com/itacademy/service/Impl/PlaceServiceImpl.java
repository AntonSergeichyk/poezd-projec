package com.itacademy.service.Impl;

import com.itacademy.dto.PlaceDto;
import com.itacademy.entity.Place;
import com.itacademy.repository.PlaceRepository;
import com.itacademy.service.interfaces.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<Place> findAllByWagonIdAndReserved(Serializable wagonId, Boolean reserved) {
        return placeRepository.findAllByWagonIdAndReserved(wagonId, reserved);
    }

    @Override
    public List<PlaceDto> findCountPlaceByTypeByWagonId(Serializable wagonId) {
        return placeRepository.findCountPlaceByTypeByWagonId(wagonId);
    }

    @Override
    public List<PlaceDto> findCountPlaceByTrainIdByWagonType(Serializable trainId) {
        return placeRepository.findCountPlaceByTrainIdByWagonType(trainId);
    }

    @Override
    public Place save(Place object) {
        return placeRepository.save(object);
    }

    @Override
    public List<Place> findAll() {
        Iterable<Place> result = placeRepository.findAll();
        ArrayList<Place> plases = new ArrayList<>();
        result.forEach(plases::add);
        return plases;
    }

    @Override
    public Place find(Long id) {
        Optional<Place> place = placeRepository.findById(id);
        return place.orElse(null);
    }

    @Override
    public void update(Place object) {

    }

    @Override
    public void delete(Place object) {
        placeRepository.delete(object);
    }
}

