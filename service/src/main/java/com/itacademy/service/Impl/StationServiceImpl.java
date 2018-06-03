package com.itacademy.service.Impl;

import com.itacademy.entity.Station;
import com.itacademy.repository.StationRepository;
import com.itacademy.service.interfaces.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    @Autowired
    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Station save(Station object) {
        return stationRepository.save(object);
    }

    @Override
    public List<Station> findAll() {
        Iterable<Station> result = stationRepository.findAll();
        ArrayList<Station> stations= new ArrayList<>();
        result.forEach(stations::add);
        return stations;
    }

    @Override
    public Station find(Long id) {
        Optional<Station> station= stationRepository.findById(id);
        return station.orElse(null);
    }

    @Override
    public void update(Station object) {

    }

    @Override
    public void delete(Station object) {
        stationRepository.delete(object);
    }
}
