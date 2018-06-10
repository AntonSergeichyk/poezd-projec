package com.itacademy.service.Impl;

import com.itacademy.entity.Train;
import com.itacademy.repository.TrainRepository;
import com.itacademy.service.interfaces.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    @Autowired
    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public Train findByName(String trainName) {
        Optional<Train> train = trainRepository.findByName(trainName);
        return train.orElse(null);
    }

    @Override
    public Train save(Train object) {
        return trainRepository.save(object);
    }

    @Override
    public List<Train> findAll() {
        Iterable<Train> result = trainRepository.findAll();
        ArrayList<Train> trains = new ArrayList<>();
        result.forEach(trains::add);
        return trains;
    }

    @Override
    public Train find(Long id) {
        Optional<Train> train = trainRepository.findById(id);
        return train.orElse(null);
    }

    @Override
    public void update(Train object) {

    }

    @Override
    public void delete(Train object) {
        trainRepository.delete(object);
    }
}
