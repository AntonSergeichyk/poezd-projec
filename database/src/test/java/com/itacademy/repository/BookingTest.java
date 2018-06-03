package com.itacademy.dao;

import com.itacademy.dao.interfaces.*;
import com.itacademy.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class BookingTest extends BaseDaoTest {


    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private TypePlaceDao typePlaceDao;
    @Autowired
    private TypeWagonDao typeWagonDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private WagonDao wagonDao;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", bookingDao);
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

        Integer roleId = roleDao.save(role);
        Assert.assertNotNull("Id is null", roleId);
        Long userId = userDao.save(user);
        Assert.assertNotNull("Id is null", userId);
        Integer typePlaceId = typePlaceDao.save(typePlace);
        Assert.assertNotNull("Id is null", typePlaceId);
        Integer typeWagonId = typeWagonDao.save(typeWagon);
        Assert.assertNotNull("Id is null", typeWagonId);
        Long trainId = trainDao.save(train);
        Assert.assertNotNull("Id is null", trainId);
        Long wagonId = wagonDao.save(wagon);
        Assert.assertNotNull("Id is null", wagonId);
        Long placeId = placeDao.save(place);
        Assert.assertNotNull("Id is null", placeId);
        Long bokingId = bookingDao.save(booking);
        Assert.assertNotNull("Id is null", bokingId);
    }

    @Test
    public void findBooking() {
        List<Booking> bookings = bookingDao.findAll();
        assertThat(bookings, hasSize(3));
        Booking booking = bookings.get(0);
        booking = bookingDao.find(booking.getId());
        assertThat(booking.getUser().getName(), equalTo("Anton"));
    }

    @Test
    public void findByUserId() {
        List<User> users = userDao.findByNamePassword("Anton", "pass");
        assertThat(users, hasSize(1));
        User user = users.get(0);
        List<Booking> results = bookingDao.findByUserId(user.getId());
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getUser().getName(), equalTo("Anton"));
    }

    @Test
    public void findByWagonId() {
        Train train = trainDao.findByName("минск-брест");
        Assert.assertNotNull("Entity is null", train);
        Wagon wagon = wagonDao.findByNumber(1, train.getId());
        List<Booking> results = bookingDao.findByWagonId(wagon.getId());
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getUser().getName(), equalTo("Anton"));
    }
}
