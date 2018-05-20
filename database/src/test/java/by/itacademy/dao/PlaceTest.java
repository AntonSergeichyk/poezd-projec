package by.itacademy.dao;

import by.itacademy.dao.impl.PlaceDaoImpl;
import by.itacademy.dao.impl.TrainDaoImpl;
import by.itacademy.dao.impl.WagonDaoImpl;
import by.itacademy.entity.Place;
import by.itacademy.entity.Train;
import by.itacademy.entity.TypePlace;
import by.itacademy.entity.TypeWagon;
import by.itacademy.entity.Wagon;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class PlaceTest extends BaseDaoTest {

    private WagonDaoImpl wagonDao = WagonDaoImpl.getInstance();
    private TrainDaoImpl trainDao = TrainDaoImpl.getInstance();
    private PlaceDaoImpl placeDao = PlaceDaoImpl.getInstance();

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

    @Test
    public void findAllFreePlaceByWagonId() {
        Long wagonId = wagonDao.findByNumber(1).getId();
        Long trainId = trainDao.findByName("минск-дзержинск").getId();
        List<Place> results = placeDao.findAllFreePlaceByWagonIdAndTrainId(wagonId, trainId);
        assertThat(results, hasSize(4));
    }
}
