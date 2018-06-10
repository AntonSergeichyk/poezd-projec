package com.itacademy.repository;

import com.itacademy.entity.Station;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class StationTest extends BaseRepositoryTes {

    @Autowired
    private StationRepository stationRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", stationRepository);
    }

    @Test
    public void saveStation() {
        Station station = new Station("Минск-Пассажирский");
        Station stationId = stationRepository.save(station);
        Assert.assertNotNull("Id is null", stationId.getId());
    }

    @Test
    public void findStation() {
        Iterable<Station> stations = stationRepository.findAll();
        List<Station> values = new ArrayList<>();
        stations.forEach(values::add);
        final int expectedSize = 6;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
    }
}
