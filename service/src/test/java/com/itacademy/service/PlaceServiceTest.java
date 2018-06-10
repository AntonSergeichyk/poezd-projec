package com.itacademy.service;

import com.itacademy.dto.PlaceDto;
import com.itacademy.entity.Place;
import com.itacademy.entity.Train;
import com.itacademy.entity.Wagon;
import com.itacademy.service.interfaces.PlaceService;
import com.itacademy.service.interfaces.TrainService;
import com.itacademy.service.interfaces.WagonService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class PlaceServiceTest extends BaseServiceTes {

    @Autowired
    private TrainService trainService;
    @Autowired
    private WagonService wagonService;
    @Autowired
    private PlaceService placeService;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", placeService);
    }

    @Test
    public void findAllByWagonIdAndReserved() {
        Train train = trainService.findByName("минск-брест");
        Assert.assertNotNull("Entity is null", train);
        Long trainId = train.getId();
        Wagon wagon = wagonService.findByNumberAndTrainId(1, trainId);
        Long wagonId = wagon.getId();
        List<Place> results = placeService.findAllByWagonIdAndReserved(wagonId, false);
        assertThat(results, hasSize(3));
    }

    @Test
    public void findCountPlaceByTypeByWagonId() {
        Train train = trainService.findByName("минск-брест");
        Long trainId = train.getId();
        Wagon wagon = wagonService.findByNumberAndTrainId(1, trainId);
        Long wagonId = wagon.getId();
        List<PlaceDto> placesDto = placeService.findCountPlaceByTypeByWagonId(wagonId);
        assertThat(placesDto, hasSize(3));
    }

    @Test
    public void findCountPlaceByTrainIdByWagonType() {
        Train train = trainService.findByName("минск-брест");
        Long trainId = train.getId();
        List<PlaceDto> placeDtos = placeService.findCountPlaceByTrainIdByWagonType(trainId, false);
    }
}
