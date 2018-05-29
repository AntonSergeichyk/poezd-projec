package com.itacademy.util;

import com.itacademy.dao.impl.*;
import com.itacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;

@Component
@Transactional
public class ProjectTestDataImporter {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private RoleDaoImpl roleDao;
    @Autowired
    private BookingDaoImpl bookingDao;
    @Autowired
    private PlaceDaoImpl placeDao;
    @Autowired
    private StationDaoImpl stationDao;
    @Autowired
    private TimeTableDaoImpl timeTableDao;
    @Autowired
    private TrainDaoImpl trainDao;
    @Autowired
    private TypePlaceDaoImpl typePlaceDao;
    @Autowired
    private TypeWagonDaoImpl typeWagonDao;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private WagonDaoImpl wagonDao;

    public void importTestData() {
        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            Role user = saveRole(session, "USER");
            Role admin = saveRole(session, "ADMIN");

            User anton = saveUser(session, user, "Anton", "pass", "123qwerty@gmail.com");
            User andrey = saveUser(session, admin, "Andrey", "passw", "12qwerty@gmail.com");
            User ivan = saveUser(session, user, "Ivan", "password", "qwerty@gmail.com");

            Station minsk = saveStation(session, "minsk");
            Station brest = saveStation(session, "brest");
            Station baranovichy = saveStation(session, "baranovichy");
            Station grodno = saveStation(session, "grodno");
            Station slonim = saveStation(session, "slonim");
            Station dzarjinsk = saveStation(session, "dzarjinsk");

            Train trainFirst = saveTrain(session, 1, "минск-брест");
            Train trainSecond = saveTrain(session, 2, "минск-барановичи");
            Train trainThird = saveTrain(session, 3, "минск-гродно");
            Train trainFourth = saveTrain(session, 4, "минск-слоним");
            Train trainFifth = saveTrain(session, 5, "минск-дзержинск");

            TimeTable timeTableFirst = saveTimeTable(session, minsk, brest, trainFirst,
                    LocalDate.of(2018, Month.MAY, 28), LocalDate.of(2018, Month.MAY, 28));
            TimeTable timeTableSecond = saveTimeTable(session, minsk, baranovichy, trainSecond,
                    LocalDate.of(2018, Month.MAY, 28), LocalDate.of(2018, Month.MAY, 28));
            TimeTable timeTableThird = saveTimeTable(session, minsk, grodno, trainThird,
                    LocalDate.of(2018, Month.MAY, 28), LocalDate.of(2018, Month.MAY, 28));
            TimeTable timeTableFoutth = saveTimeTable(session, minsk, slonim, trainFourth,
                    LocalDate.of(2018, Month.MAY, 28), LocalDate.of(2018, Month.MAY, 28));
            TimeTable timeTableFifth = saveTimeTable(session, minsk, dzarjinsk, trainFifth,
                    LocalDate.of(2018, Month.MAY, 28), LocalDate.of(2018, Month.MAY, 28));

            TypeWagon plackartniy = saveTypeWagon(session, "плацкартный");
            TypeWagon kype = saveTypeWagon(session, "купейный");
            TypeWagon sedentary = saveTypeWagon(session, "сидячий");
            TypeWagon common = saveTypeWagon(session, "общий");

            Wagon wagonFirst = saveWagon(session, 1, trainFirst, plackartniy);
            Wagon wagonSecond = saveWagon(session, 2, trainFirst, kype);
            Wagon wagonThird = saveWagon(session, 3, trainFirst, sedentary);
            Wagon wagonFourth = saveWagon(session, 4, trainFirst, common);
            Wagon wagonFifth = saveWagon(session, 1, trainSecond, plackartniy);
            Wagon wagonSixth = saveWagon(session, 2, trainSecond, kype);
            Wagon wagonSeventh = saveWagon(session, 3, trainSecond, sedentary);
            Wagon wagonEighth = saveWagon(session, 4, trainSecond, common);
            Wagon wagonNinth = saveWagon(session, 1, trainThird, plackartniy);
            Wagon wagonTenth = saveWagon(session, 2, trainThird, kype);
            Wagon wagonEleventh = saveWagon(session, 3, trainThird, sedentary);
            Wagon wagonTwelfth = saveWagon(session, 4, trainThird, common);
            Wagon wagonThirteenth = saveWagon(session, 1, trainFifth, plackartniy);
            Wagon wagonFourteenth = saveWagon(session, 2, trainFifth, kype);
            Wagon wagonFifteenth = saveWagon(session, 3, trainFifth, sedentary);
            Wagon wagonSixteenth = saveWagon(session, 4, trainFifth, common);

            TypePlace typePlaceUpper = saveTypePlace(session, "Верхнее");
            TypePlace typePlaceLower = saveTypePlace(session, "Нижнее");
            TypePlace typePlaceLateral = saveTypePlace(session, "Боковое");
            TypePlace typePlaceSedentaty = saveTypePlace(session, "Сидячее");
            TypePlace typePlaceCommon = saveTypePlace(session, "Общее");

            Place place1 = savePlace(session, wagonFirst, 1, typePlaceUpper, false, 18.0);
            Place place2 = savePlace(session, wagonFirst, 2, typePlaceLower, false, 18.0);
            Place place3 = savePlace(session, wagonFirst, 3, typePlaceLateral, false, 18.0);
            Place place4 = savePlace(session, wagonSecond, 1, typePlaceUpper, false, 18.0);
            Place place5 = savePlace(session, wagonSecond, 2, typePlaceLower, false, 18.0);
            Place place6 = savePlace(session, wagonSecond, 3, typePlaceLateral, false, 18.0);
            Place place7 = savePlace(session, wagonThird, 1, typePlaceUpper, false, 18.0);
            Place place8 = savePlace(session, wagonThird, 2, typePlaceLower, false, 18.0);
            Place place9 = savePlace(session, wagonThird, 3, typePlaceLateral, false, 18.0);
            Place place10 = savePlace(session, wagonFourth, 1, typePlaceUpper, false, 18.0);
            Place place11 = savePlace(session, wagonFourth, 2, typePlaceLower, false, 18.0);
            Place place12 = savePlace(session, wagonFourth, 3, typePlaceLateral, false, 18.0);
            Place place13 = savePlace(session, wagonFifth, 1, typePlaceSedentaty, false, 13.0);
            Place place14 = savePlace(session, wagonFifth, 2, typePlaceSedentaty, false, 13.0);
            Place place15 = savePlace(session, wagonFifth, 3, typePlaceSedentaty, false, 13.0);
            Place place16 = savePlace(session, wagonSixth, 1, typePlaceUpper, false, 18.0);
            Place place17 = savePlace(session, wagonSixth, 2, typePlaceLower, false, 18.0);
            Place place18 = savePlace(session, wagonSixth, 3, typePlaceLateral, false, 18.0);
            Place place19 = savePlace(session, wagonSeventh, 1, typePlaceUpper, false, 18.0);
            Place place20 = savePlace(session, wagonSeventh, 2, typePlaceLower, false, 18.0);
            Place place21 = savePlace(session, wagonSeventh, 3, typePlaceLateral, false, 18.0);
            Place place22 = savePlace(session, wagonEighth, 1, typePlaceUpper, false, 18.0);
            Place place23 = savePlace(session, wagonEighth, 2, typePlaceLower, false, 18.0);
            Place place24 = savePlace(session, wagonEighth, 3, typePlaceLateral, false, 18.0);
            Place place25 = savePlace(session, wagonNinth, 1, typePlaceUpper, false, 18.0);
            Place place26 = savePlace(session, wagonNinth, 2, typePlaceLower, false, 18.0);
            Place place27 = savePlace(session, wagonNinth, 3, typePlaceLateral, false, 18.0);
            Place place28 = savePlace(session, wagonTenth, 1, typePlaceCommon, false, 10.0);
            Place place29 = savePlace(session, wagonTenth, 2, typePlaceCommon, false, 10.0);
            Place place30 = savePlace(session, wagonTenth, 3, typePlaceCommon, false, 10.0);
            Place place31 = savePlace(session, wagonEleventh, 1, typePlaceUpper, false, 18.0);
            Place place32 = savePlace(session, wagonEleventh, 2, typePlaceLower, false, 18.0);
            Place place33 = savePlace(session, wagonEleventh, 3, typePlaceLateral, false, 18.0);
            Place place34 = savePlace(session, wagonTwelfth, 1, typePlaceUpper, false, 18.0);
            Place place35 = savePlace(session, wagonTwelfth, 2, typePlaceLower, false, 18.0);
            Place place36 = savePlace(session, wagonTwelfth, 3, typePlaceLateral, false, 18.0);
            Place place37 = savePlace(session, wagonThirteenth, 1, typePlaceUpper, false, 18.0);
            Place place39 = savePlace(session, wagonThirteenth, 2, typePlaceLower, false, 18.0);
            Place place40 = savePlace(session, wagonThirteenth, 3, typePlaceLateral, false, 18.0);
            Place place41 = savePlace(session, wagonFourteenth, 1, typePlaceSedentaty, false, 13.0);
            Place place42 = savePlace(session, wagonFourteenth, 2, typePlaceSedentaty, false, 13.0);
            Place place43 = savePlace(session, wagonFourteenth, 3, typePlaceSedentaty, false, 13.0);
            Place place44 = savePlace(session, wagonFifteenth, 1, typePlaceUpper, false, 18.0);
            Place place45 = savePlace(session, wagonFifteenth, 2, typePlaceLower, false, 18.0);
            Place place46 = savePlace(session, wagonFifteenth, 3, typePlaceLateral, false, 18.0);
            Place place47 = savePlace(session, wagonSixteenth, 1, typePlaceUpper, false, 18.0);
            Place place48 = savePlace(session, wagonSixteenth, 2, typePlaceLower, false, 18.0);
            Place place49 = savePlace(session, wagonSixteenth, 3, typePlaceLateral, false, 18.0);

            saveBooking(session, anton, new UserData("Сергейчук", "Антон", "Николаевич", "АВ232323"), place1);
            saveBooking(session, andrey, new UserData("Сергейчук", "Андрей", "Николаевич", "АВ232324"), place15);
            saveBooking(session, ivan, new UserData("Иванов", "Иван", "Иванович", "АВ232325"), place40);
            session.getTransaction().commit();
        }
    }

    private Role saveRole(Session session, String name) {
        Role role = new Role(name);
        roleDao.save(role);

        return role;
    }

    private User saveUser(Session session, Role role, String name, String password, String mailbox) {
        User user = new User(role, name, password, mailbox);
        userDao.save(user);

        return user;
    }

    private Station saveStation(Session session, String name) {
        Station station = new Station(name);
        stationDao.save(station);

        return station;
    }

    private Train saveTrain(Session session, Integer number, String name) {
        Train train = new Train(number, name);
        trainDao.save(train);

        return train;
    }

    private TimeTable saveTimeTable(Session session, Station stationStart, Station stationFinish, Train train, LocalDate timeStart, LocalDate timeFinish) {
        TimeTable timeTable = new TimeTable(stationStart, stationFinish, train, timeStart, timeFinish);
        timeTableDao.save(timeTable);

        return timeTable;
    }

    private TypeWagon saveTypeWagon(Session session, String type) {
        TypeWagon typeWagon = new TypeWagon(type);
        typeWagonDao.save(typeWagon);

        return typeWagon;
    }

    private Wagon saveWagon(Session session, Integer number, Train train, TypeWagon typeWagon) {
        Wagon wagon = new Wagon(number, train, typeWagon);
        wagonDao.save(wagon);

        return wagon;
    }

    private TypePlace saveTypePlace(Session session, String type) {
        TypePlace typePlace = new TypePlace(type);
        typePlaceDao.save(typePlace);

        return typePlace;
    }

    private Place savePlace(Session session, Wagon wagon, Integer number, TypePlace typePlace, Boolean reserved, Double cost) {
        Place place = new Place(wagon, number, typePlace, reserved, cost);
        placeDao.save(place);

        return place;
    }

    private Booking saveBooking(Session session, User user, UserData userData, Place place) {
        Booking booking = new Booking(user, userData, place);
        bookingDao.save(booking);

        return booking;
    }
}
