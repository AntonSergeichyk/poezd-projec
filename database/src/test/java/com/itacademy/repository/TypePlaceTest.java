package com.itacademy.repository;

import com.itacademy.entity.TypePlace;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TypePlaceTest extends BaseRepositoryTes {

    @Autowired
    private TypePlaceRepository typePlaceRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", typePlaceRepository);
    }

    @Test
    public void saveTypePlace() {
        TypePlace typePlace = new TypePlace("нижнее");
        TypePlace typePlaceId = typePlaceRepository.save(typePlace);
        Assert.assertNotNull("Id is null", typePlaceId.getId());
    }

    @Test
    public void findTypePlace() {
        Iterable<TypePlace> typePlaces = typePlaceRepository.findAll();
        List<TypePlace> values = new ArrayList<>();
        typePlaces.forEach(values::add);
        final int expectedSize = 5;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
        assertThat(values.get(0).getType(), Matchers.equalTo("Верхнее"));
    }
}
