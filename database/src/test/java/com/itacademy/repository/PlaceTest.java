package com.itacademy.repository;

import com.itacademy.dto.PlaceDto;
import com.itacademy.entity.*;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class PlaceTest extends BaseRepositoryTes {


    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private TypePlaceRepository typePlaceRepository;
    @Autowired
    private TypeWagonRepository typeWagonRepository;
    @Autowired
    private WagonRepository wagonRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", placeRepository);
    }

    @Test
    public void savePlace() {
        TypePlace typePlace = new TypePlace("нижнее");
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        Place place = new Place(wagon, 55, typePlace, true, 12.5);

        TypePlace typePlaceId = typePlaceRepository.save(typePlace);
        Assert.assertNotNull("Id is null", typePlaceId.getId());
        TypeWagon typeWagonId = typeWagonRepository.save(typeWagon);
        Assert.assertNotNull("Id is null", typeWagonId.getId());
        Train trainId = trainRepository.save(train);
        Assert.assertNotNull("Id is null", trainId.getId());
        Wagon wagonId = wagonRepository.save(wagon);
        Assert.assertNotNull("Id is null", wagonId.getId());
        Place placeId = placeRepository.save(place);
        Assert.assertNotNull("Id is null", placeId.getId());
    }

    @Test
    public void findPlace() {
        Iterable<Place> places = placeRepository.findAll();
        List<Place> values = new ArrayList<>();
        places.forEach(values::add);
        final int expectedSize = 48;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
    }

    @Test
    public void findAllByWagonIdAndReserved() {
        Optional<Train> train = trainRepository.findByName("минск-брест");
        Assert.assertNotNull("Entity is null", train);
        assertTrue(train.isPresent());
        Long trainId = train.get().getId();
        Optional<Wagon> wagon = wagonRepository.findByNumberAndTrainId(1, trainId);
        assertTrue(wagon.isPresent());
        Long wagonId = wagon.get().getId();
        List<Place> results = placeRepository.findAllByWagonIdAndReserved(wagonId, false);
        assertThat(results, hasSize(3));
    }

    @Test
    public void findCountPlaceByTypeByWagonId() {
        Optional<Train> train = trainRepository.findByName("минск-брест");
        assertTrue(train.isPresent());
        Long trainId = train.get().getId();
        Optional<Wagon> wagon = wagonRepository.findByNumberAndTrainId(1, trainId);
        assertTrue(wagon.isPresent());
        Long wagonId = wagon.get().getId();
        List<PlaceDto> placesDto = placeRepository.findCountPlaceByTypeByWagonId(wagonId);
        assertThat(placesDto, hasSize(3));
    }

    @Test
    public void findCountPlaceByTrainIdByWagonType() {
        Optional<Train> train = trainRepository.findByName("минск-брест");
        assertTrue(train.isPresent());
        Long trainId = train.get().getId();
        List<PlaceDto> placeDtos = placeRepository.findCountPlaceByTrainIdByWagonType(trainId, false);
        assertThat(placeDtos, hasSize(4));
    }
}
