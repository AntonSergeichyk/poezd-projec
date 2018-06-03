package com.itacademy.service.Impl;

import com.itacademy.entity.Wagon;
import com.itacademy.repository.WagonRepository;
import com.itacademy.service.interfaces.WagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WagonServiceImpl implements WagonService {

    private final WagonRepository wagonRepository;

    @Autowired
    public WagonServiceImpl(WagonRepository wagonRepository) {
        this.wagonRepository = wagonRepository;
    }

    @Override
    public Wagon findByNumberAndTrainId(Integer number, Long trainId) {
        Optional<Wagon> wagon = wagonRepository.findByNumberAndTrainId(number, trainId);
        return wagon.orElse(null);
    }

    @Override
    public List<Wagon> findByTrainName(String trainName) {
        return wagonRepository.findByTrainName(trainName);
    }

    @Override
    public Wagon save(Wagon object) {
        return wagonRepository.save(object);
    }

    @Override
    public List<Wagon> findAll() {
        Iterable<Wagon> results = wagonRepository.findAll();
        ArrayList<Wagon> wagons = new ArrayList<>();
        results.forEach(wagons::add);
        return wagons;
    }

    @Override
    public Wagon find(Long id) {
        Optional<Wagon> wagon = wagonRepository.findById(id);
        return wagon.orElse(null);
    }

    @Override
    public void update(Wagon object) {

    }

    @Override
    public void delete(Wagon object) {
        wagonRepository.delete(object);
    }
}
