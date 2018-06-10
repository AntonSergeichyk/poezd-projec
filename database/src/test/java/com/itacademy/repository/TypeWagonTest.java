package com.itacademy.repository;

import com.itacademy.entity.TypeWagon;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TypeWagonTest extends BaseRepositoryTes {

    @Autowired
    TypeWagonRepository typeWagonRepository;
    @Autowired
    TrainRepository trainRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", typeWagonRepository);
    }

    @Test
    public void saveWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        TypeWagon typeWagonId = typeWagonRepository.save(typeWagon);
        Assert.assertNotNull("Id is null", typeWagonId.getId());
    }

    @Test
    public void findWagon() {
        Iterable<TypeWagon> typeWagons = typeWagonRepository.findAll();
        List<TypeWagon> values = new ArrayList<>();
        typeWagons.forEach(values::add);
        final int expectedSize = 4;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
        assertThat(values.get(0).getType(), Matchers.equalTo("плацкартный"));
    }
}
