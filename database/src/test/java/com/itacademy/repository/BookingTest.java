package com.itacademy.repository;

import com.itacademy.entity.*;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class BookingTest extends BaseRepositoryTes {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private TypePlaceRepository typePlaceRepository;
    @Autowired
    private TypeWagonRepository typeWagonRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WagonRepository wagonRepository;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", bookingRepository);
    }

    @Test
    public void saveBooking() {
        Role role = new Role("user");
        User user = new User(role, "Anton3", "11111111", "qwerty@gmail.com");
        UserData userData = new UserData("Сергейчук", "Антон", "Николаевич", "AB2332222");
        TypePlace typePlace = new TypePlace("нижнее");
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        Place place = new Place(wagon, 55, typePlace, true, 12.5);
        Booking booking = new Booking(user, userData, place);

        Role role1 = roleRepository.save(role);
        Assert.assertNotNull("Id is null", role1.getId());
        User user1 = userRepository.save(user);
        Assert.assertNotNull("Id is null", user1.getId());
        TypePlace typePlace1 = typePlaceRepository.save(typePlace);
        Assert.assertNotNull("Id is null", typePlace1.getId());
        TypeWagon typeWagon1 = typeWagonRepository.save(typeWagon);
        Assert.assertNotNull("Id is null", typeWagon1.getId());
        Train train1 = trainRepository.save(train);
        Assert.assertNotNull("Id is null", train1.getId());
        Wagon wagonId = wagonRepository.save(wagon);
        Assert.assertNotNull("Id is null", wagonId.getId());
        Place placeId = placeRepository.save(place);
        Assert.assertNotNull("Id is null", placeId.getId());
        Booking bokingId = bookingRepository.save(booking);
        Assert.assertNotNull("Id is null", bokingId.getId());
    }

    @Test
    public void findBooking() {
        Iterable<Booking> bookings = bookingRepository.findAll();
        List<Booking> values = new ArrayList<>();
        bookings.forEach(values::add);
        final int expectedSize = 3;
        assertThat(values, IsCollectionWithSize.hasSize(expectedSize));
    }

    @Test
    public void findByUserId() {
        Optional<User> user = userRepository.findByNameAndPassword("Anton", "pass");
        assertTrue(user.isPresent());
        List<Booking> results = bookingRepository.findAllByUserId(user.get().getId());
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getUser().getName(), equalTo("Anton"));
    }

    @Test
    public void findByWagonId() {
        Optional<Train> train = trainRepository.findByName("минск-брест");
        assertTrue(train.isPresent());
        Optional<Wagon> wagon = wagonRepository.findByNumberAndTrainId(1, train.get().getId());
        assertTrue(wagon.isPresent());
        List<Booking> results = bookingRepository.findAllByPlaceWagonId(wagon.get().getId());
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getUser().getName(), equalTo("Anton"));
    }
}
