package by.itacademy.dao;

import by.itacademy.entity.Booking;
import by.itacademy.entity.Place;
import by.itacademy.entity.Role;
import by.itacademy.entity.Train;
import by.itacademy.entity.TypePlace;
import by.itacademy.entity.TypeWagon;
import by.itacademy.entity.User;
import by.itacademy.entity.UserData;
import by.itacademy.entity.Wagon;
import org.junit.Test;

public class BookingTest extends BaseDaoTest {

    @Test
    public void saveBooking() {
        Role role = new Role("user");
        User user = new User(role, "Anton", "11111111", "qwerty@gmail.com");
        UserData userData = new UserData("Сергейчук", "Антон", "Николаевич", "AB2332222");
        TypePlace typePlace = new TypePlace("нижнее");
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        Place place = new Place(wagon, 55, typePlace, true, 12.5);
        Booking booking = new Booking(user, userData, place);

        save(role, user, typeWagon, train, wagon, typePlace, place, booking);
    }

    @Test
    public void findBooking() {
        Role role = new Role("user");
        User user = new User(role, "Anton", "11111111", "qwerty@gmail.com");
        UserData userData = new UserData("Сергейчук", "Антон", "Николаевич", "AB2332222");
        TypePlace typePlace = new TypePlace("нижнее");
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        Place place = new Place(wagon, 55, typePlace, true, 12.5);
        Booking booking = new Booking(user, userData, place);

        find(role, user, typeWagon, train, wagon, typePlace, place, booking);
    }
}
