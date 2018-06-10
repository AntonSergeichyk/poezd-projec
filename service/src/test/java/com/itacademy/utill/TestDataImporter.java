package com.itacademy.utill;

import com.itacademy.entity.*;
import com.itacademy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
import java.time.Month;

@Component
public class TestDataImporter {

    private final EntityManagerFactory entityManagerFactory;
    private final RoleRepository roleRepository;
    private final BookingRepository bookingRepository;
    private final PlaceRepository placeRepository;
    private final StationRepository stationRepository;
    private final TimeTableRepository timeTableRepository;
    private final TrainRepository trainRepository;
    private final TypePlaceRepository typePlaceRepository;
    private final TypeWagonRepository typeWagonRepository;
    private final UserRepository userRepository;
    private final WagonRepository wagonRepository;

    @Autowired
    public TestDataImporter(EntityManagerFactory entityManagerFactory, RoleRepository roleRepository,
                            BookingRepository bookingRepository, PlaceRepository placeRepository,
                            StationRepository stationRepository, TimeTableRepository timeTableRepository,
                            TrainRepository trainRepository, TypePlaceRepository typePlaceRepository,
                            TypeWagonRepository typeWagonRepository, UserRepository userRepository,
                            WagonRepository wagonRepository) {
        this.entityManagerFactory = entityManagerFactory;
        this.roleRepository = roleRepository;
        this.bookingRepository = bookingRepository;
        this.placeRepository = placeRepository;
        this.stationRepository = stationRepository;
        this.timeTableRepository = timeTableRepository;
        this.trainRepository = trainRepository;
        this.typePlaceRepository = typePlaceRepository;
        this.typeWagonRepository = typeWagonRepository;
        this.userRepository = userRepository;
        this.wagonRepository = wagonRepository;
    }

    public void importTestData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Role user = saveRole(entityManager, "USER");
        Role admin = saveRole(entityManager, "ADMIN");

        User anton = saveUser(entityManager, user, "Anton", "pass", "123qwerty@gmail.com");
        User andrey = saveUser(entityManager, admin, "Andrey", "passw", "12qwerty@gmail.com");
        User ivan = saveUser(entityManager, user, "Ivan", "password", "qwerty@gmail.com");

        Station minsk = saveStation(entityManager, "minsk");
        Station brest = saveStation(entityManager, "brest");
        Station baranovichy = saveStation(entityManager, "baranovichy");
        Station grodno = saveStation(entityManager, "grodno");
        Station slonim = saveStation(entityManager, "slonim");
        Station dzarjinsk = saveStation(entityManager, "dzarjinsk");

        Train trainFirst = saveTrain(entityManager, 1, "минск-брест");
        Train trainSecond = saveTrain(entityManager, 2, "минск-барановичи");
        Train trainThird = saveTrain(entityManager, 3, "минск-гродно");
        Train trainFourth = saveTrain(entityManager, 4, "минск-слоним");
        Train trainFifth = saveTrain(entityManager, 5, "минск-дзержинск");

        TimeTable timeTableFirst = saveTimeTable(entityManager, minsk, brest, trainFirst,
                LocalDateTime.of(2018, Month.MAY, 28,0,0), LocalDateTime.of(2018, Month.MAY, 28, 0, 0));
        TimeTable timeTableSecond = saveTimeTable(entityManager, minsk, baranovichy, trainSecond,
                LocalDateTime.of(2018, Month.MAY, 28,0,0), LocalDateTime.of(2018, Month.MAY, 28, 0, 0));
        TimeTable timeTableThird = saveTimeTable(entityManager, minsk, grodno, trainThird,
                LocalDateTime.of(2018, Month.MAY, 28,0,0), LocalDateTime.of(2018, Month.MAY, 28, 0, 0));
        TimeTable timeTableFoutth = saveTimeTable(entityManager, minsk, slonim, trainFourth,
                LocalDateTime.of(2018, Month.MAY, 28,0,0), LocalDateTime.of(2018, Month.MAY, 28, 0, 0));
        TimeTable timeTableFifth = saveTimeTable(entityManager, minsk, dzarjinsk, trainFifth,
                LocalDateTime.of(2018, Month.MAY, 28,0,0), LocalDateTime.of(2018, Month.MAY, 28, 0, 0));

        TypeWagon plackartniy = saveTypeWagon(entityManager, "плацкартный");
        TypeWagon kype = saveTypeWagon(entityManager, "купейный");
        TypeWagon sedentary = saveTypeWagon(entityManager, "сидячий");
        TypeWagon common = saveTypeWagon(entityManager, "общий");

        Wagon wagonFirst = saveWagon(entityManager, 1, trainFirst, plackartniy);
        Wagon wagonSecond = saveWagon(entityManager, 2, trainFirst, kype);
        Wagon wagonThird = saveWagon(entityManager, 3, trainFirst, sedentary);
        Wagon wagonFourth = saveWagon(entityManager, 4, trainFirst, common);
        Wagon wagonFifth = saveWagon(entityManager, 1, trainSecond, plackartniy);
        Wagon wagonSixth = saveWagon(entityManager, 2, trainSecond, kype);
        Wagon wagonSeventh = saveWagon(entityManager, 3, trainSecond, sedentary);
        Wagon wagonEighth = saveWagon(entityManager, 4, trainSecond, common);
        Wagon wagonNinth = saveWagon(entityManager, 1, trainThird, plackartniy);
        Wagon wagonTenth = saveWagon(entityManager, 2, trainThird, kype);
        Wagon wagonEleventh = saveWagon(entityManager, 3, trainThird, sedentary);
        Wagon wagonTwelfth = saveWagon(entityManager, 4, trainThird, common);
        Wagon wagonThirteenth = saveWagon(entityManager, 1, trainFifth, plackartniy);
        Wagon wagonFourteenth = saveWagon(entityManager, 2, trainFifth, kype);
        Wagon wagonFifteenth = saveWagon(entityManager, 3, trainFifth, sedentary);
        Wagon wagonSixteenth = saveWagon(entityManager, 4, trainFifth, common);

        TypePlace typePlaceUpper = saveTypePlace(entityManager, "Верхнее");
        TypePlace typePlaceLower = saveTypePlace(entityManager, "Нижнее");
        TypePlace typePlaceLateral = saveTypePlace(entityManager, "Боковое");
        TypePlace typePlaceSedentaty = saveTypePlace(entityManager, "Сидячее");
        TypePlace typePlaceCommon = saveTypePlace(entityManager, "Общее");

        Place place1 = savePlace(entityManager, wagonFirst, 1, typePlaceUpper, false, 18.0);
        Place place2 = savePlace(entityManager, wagonFirst, 2, typePlaceLower, false, 18.0);
        Place place3 = savePlace(entityManager, wagonFirst, 3, typePlaceLateral, false, 18.0);
        Place place4 = savePlace(entityManager, wagonSecond, 1, typePlaceUpper, false, 18.0);
        Place place5 = savePlace(entityManager, wagonSecond, 2, typePlaceLower, false, 18.0);
        Place place6 = savePlace(entityManager, wagonSecond, 3, typePlaceLateral, false, 18.0);
        Place place7 = savePlace(entityManager, wagonThird, 1, typePlaceUpper, false, 18.0);
        Place place8 = savePlace(entityManager, wagonThird, 2, typePlaceLower, false, 18.0);
        Place place9 = savePlace(entityManager, wagonThird, 3, typePlaceLateral, false, 18.0);
        Place place10 = savePlace(entityManager, wagonFourth, 1, typePlaceUpper, false, 18.0);
        Place place11 = savePlace(entityManager, wagonFourth, 2, typePlaceLower, false, 18.0);
        Place place12 = savePlace(entityManager, wagonFourth, 3, typePlaceLateral, false, 18.0);
        Place place13 = savePlace(entityManager, wagonFifth, 1, typePlaceSedentaty, false, 13.0);
        Place place14 = savePlace(entityManager, wagonFifth, 2, typePlaceSedentaty, false, 13.0);
        Place place15 = savePlace(entityManager, wagonFifth, 3, typePlaceSedentaty, false, 13.0);
        Place place16 = savePlace(entityManager, wagonSixth, 1, typePlaceUpper, false, 18.0);
        Place place17 = savePlace(entityManager, wagonSixth, 2, typePlaceLower, false, 18.0);
        Place place18 = savePlace(entityManager, wagonSixth, 3, typePlaceLateral, false, 18.0);
        Place place19 = savePlace(entityManager, wagonSeventh, 1, typePlaceUpper, false, 18.0);
        Place place20 = savePlace(entityManager, wagonSeventh, 2, typePlaceLower, false, 18.0);
        Place place21 = savePlace(entityManager, wagonSeventh, 3, typePlaceLateral, false, 18.0);
        Place place22 = savePlace(entityManager, wagonEighth, 1, typePlaceUpper, false, 18.0);
        Place place23 = savePlace(entityManager, wagonEighth, 2, typePlaceLower, false, 18.0);
        Place place24 = savePlace(entityManager, wagonEighth, 3, typePlaceLateral, false, 18.0);
        Place place25 = savePlace(entityManager, wagonNinth, 1, typePlaceUpper, false, 18.0);
        Place place26 = savePlace(entityManager, wagonNinth, 2, typePlaceLower, false, 18.0);
        Place place27 = savePlace(entityManager, wagonNinth, 3, typePlaceLateral, false, 18.0);
        Place place28 = savePlace(entityManager, wagonTenth, 1, typePlaceCommon, false, 10.0);
        Place place29 = savePlace(entityManager, wagonTenth, 2, typePlaceCommon, false, 10.0);
        Place place30 = savePlace(entityManager, wagonTenth, 3, typePlaceCommon, false, 10.0);
        Place place31 = savePlace(entityManager, wagonEleventh, 1, typePlaceUpper, false, 18.0);
        Place place32 = savePlace(entityManager, wagonEleventh, 2, typePlaceLower, false, 18.0);
        Place place33 = savePlace(entityManager, wagonEleventh, 3, typePlaceLateral, false, 18.0);
        Place place34 = savePlace(entityManager, wagonTwelfth, 1, typePlaceUpper, false, 18.0);
        Place place35 = savePlace(entityManager, wagonTwelfth, 2, typePlaceLower, false, 18.0);
        Place place36 = savePlace(entityManager, wagonTwelfth, 3, typePlaceLateral, false, 18.0);
        Place place37 = savePlace(entityManager, wagonThirteenth, 1, typePlaceUpper, false, 18.0);
        Place place39 = savePlace(entityManager, wagonThirteenth, 2, typePlaceLower, false, 18.0);
        Place place40 = savePlace(entityManager, wagonThirteenth, 3, typePlaceLateral, false, 18.0);
        Place place41 = savePlace(entityManager, wagonFourteenth, 1, typePlaceSedentaty, false, 13.0);
        Place place42 = savePlace(entityManager, wagonFourteenth, 2, typePlaceSedentaty, false, 13.0);
        Place place43 = savePlace(entityManager, wagonFourteenth, 3, typePlaceSedentaty, false, 13.0);
        Place place44 = savePlace(entityManager, wagonFifteenth, 1, typePlaceUpper, false, 18.0);
        Place place45 = savePlace(entityManager, wagonFifteenth, 2, typePlaceLower, false, 18.0);
        Place place46 = savePlace(entityManager, wagonFifteenth, 3, typePlaceLateral, false, 18.0);
        Place place47 = savePlace(entityManager, wagonSixteenth, 1, typePlaceUpper, false, 18.0);
        Place place48 = savePlace(entityManager, wagonSixteenth, 2, typePlaceLower, false, 18.0);
        Place place49 = savePlace(entityManager, wagonSixteenth, 3, typePlaceLateral, false, 18.0);

        saveBooking(entityManager, anton, new UserData("Сергейчук", "Антон", "Николаевич", "АВ232323"), place1);
        saveBooking(entityManager, andrey, new UserData("Сергейчук", "Андрей", "Николаевич", "АВ232324"), place15);
        saveBooking(entityManager, ivan, new UserData("Иванов", "Иван", "Иванович", "АВ232325"), place40);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    private Role saveRole(EntityManager entityManager, String name) {
        Role role = new Role(name);
        roleRepository.save(role);

        return role;
    }

    private User saveUser(EntityManager entityManager, Role role, String name, String password, String mailbox) {
        User user = new User(role, name, password, mailbox);
        userRepository.save(user);

        return user;
    }

    private Station saveStation(EntityManager entityManager, String name) {
        Station station = new Station(name);
        stationRepository.save(station);

        return station;
    }

    private Train saveTrain(EntityManager entityManager, Integer number, String name) {
        Train train = new Train(number, name);
        trainRepository.save(train);

        return train;
    }

    private TimeTable saveTimeTable(EntityManager entityManager, Station stationStart, Station stationFinish, Train train, LocalDateTime timeStart, LocalDateTime timeFinish) {
        TimeTable timeTable = new TimeTable(stationStart, stationFinish, train, timeStart, timeFinish);
        timeTableRepository.save(timeTable);

        return timeTable;
    }

    private TypeWagon saveTypeWagon(EntityManager entityManager, String type) {
        TypeWagon typeWagon = new TypeWagon(type);
        typeWagonRepository.save(typeWagon);

        return typeWagon;
    }

    private Wagon saveWagon(EntityManager entityManager, Integer number, Train train, TypeWagon typeWagon) {
        Wagon wagon = new Wagon(number, train, typeWagon);
        wagonRepository.save(wagon);

        return wagon;
    }

    private TypePlace saveTypePlace(EntityManager entityManager, String type) {
        TypePlace typePlace = new TypePlace(type);
        typePlaceRepository.save(typePlace);

        return typePlace;
    }

    private Place savePlace(EntityManager entityManager, Wagon wagon, Integer number, TypePlace typePlace, Boolean reserved, Double cost) {
        Place place = new Place(wagon, number, typePlace, reserved, cost);
        placeRepository.save(place);

        return place;
    }

    private Booking saveBooking(EntityManager entityManager, User user, UserData userData, Place place) {
        Booking booking = new Booking(user, userData, place);
        bookingRepository.save(booking);

        return booking;
    }
}
