package by.itacademy.dao;

import by.itacademy.dao.impl.BookingDaoImpl;
import by.itacademy.dao.impl.PlaceDaoImpl;
import by.itacademy.dao.impl.RoleDaoImpl;
import by.itacademy.dao.impl.TrainDaoImpl;
import by.itacademy.dao.impl.TypePlaceDaoImpl;
import by.itacademy.dao.impl.TypeWagonDaoImpl;
import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.dao.impl.WagonDaoImpl;
import by.itacademy.entity.Booking;
import by.itacademy.entity.Place;
import by.itacademy.entity.Role;
import by.itacademy.entity.Train;
import by.itacademy.entity.TypePlace;
import by.itacademy.entity.TypeWagon;
import by.itacademy.entity.User;
import by.itacademy.entity.UserData;
import by.itacademy.entity.Wagon;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class BookingTest extends BaseDaoTest {

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

        Integer roleId = RoleDaoImpl.getInstance().save(role);
        Assert.assertNotNull("Id is null", roleId);
        Long userId = UserDaoImpl.getInstance().save(user);
        Assert.assertNotNull("Id is null", userId);
        Integer typePlaceId = TypePlaceDaoImpl.getInstance().save(typePlace);
        Assert.assertNotNull("Id is null", typePlaceId);
        Integer typeWagonId = TypeWagonDaoImpl.getInstance().save(typeWagon);
        Assert.assertNotNull("Id is null", typeWagonId);
        Long trainId = TrainDaoImpl.getInstance().save(train);
        Assert.assertNotNull("Id is null", trainId);
        Long wagonId = WagonDaoImpl.getInstance().save(wagon);
        Assert.assertNotNull("Id is null", wagonId);
        Long placeId = PlaceDaoImpl.getInstance().save(place);
        Assert.assertNotNull("Id is null", placeId);
        Long bokingId = BookingDaoImpl.getInstance().save(booking);
        Assert.assertNotNull("Id is null", bokingId);
    }

    @Test
    public void findBooking() {
        List<Booking> bookings = BookingDaoImpl.getInstance().findAll();
        assertThat(bookings, hasSize(3));
        Booking booking = bookings.get(0);
        booking = BookingDaoImpl.getInstance().find(booking.getId());
        assertThat(booking.getUser().getName(), equalTo("Anton"));
    }

    @Test
    public void findByUserId() {
        List<User> users = UserDaoImpl.getInstance().findByNamePassword("Anton", "pass");
        assertThat(users, hasSize(1));
        User user = users.get(0);
        List<Booking> results = BookingDaoImpl.getInstance().findByUserId(user.getId());
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getUser().getName(), equalTo("Anton"));
    }

    @Test
    public void findByWagonId() {
        Train train = TrainDaoImpl.getInstance().findByName("минск-брест");
        Assert.assertNotNull("Entity is null", train);
        Wagon wagon = WagonDaoImpl.getInstance().findByNumber(1, train.getId());
        List<Booking> results = BookingDaoImpl.getInstance().findByWagonId(wagon.getId());
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getUser().getName(), equalTo("Anton"));
    }
}
