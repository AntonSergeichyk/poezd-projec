package by.itacademy.dao;

import by.itacademy.entity.Place;
import by.itacademy.entity.Train;
import by.itacademy.entity.TypePlace;
import by.itacademy.entity.TypeWagon;
import by.itacademy.entity.Wagon;
import org.junit.Test;

public class PlaceTest extends BaseDaoTest {

    @Test
    public void savePlace() {
        TypePlace typePlace = new TypePlace("нижнее");
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        Place place = new Place(wagon, 55, typePlace, true, 12.5);

        save(typeWagon, train, wagon, typePlace, place);
    }

    @Test
    public void findPlace() {
        TypePlace typePlace = new TypePlace("нижнее");
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        Place place = new Place(wagon, 55, typePlace, true, 12.5);

        find(typeWagon, train, wagon, typePlace, place);
    }
}
