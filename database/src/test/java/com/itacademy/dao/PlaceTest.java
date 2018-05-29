package by.itacademy.dao;

import by.itacademy.dao.impl.PlaceDaoImpl;
import by.itacademy.dao.impl.TrainDaoImpl;
import by.itacademy.dao.impl.TypePlaceDaoImpl;
import by.itacademy.dao.impl.TypeWagonDaoImpl;
import by.itacademy.dao.impl.WagonDaoImpl;
import by.itacademy.dto.PlaceDto;
import by.itacademy.entity.Place;
import by.itacademy.entity.Train;
import by.itacademy.entity.TypePlace;
import by.itacademy.entity.TypeWagon;
import by.itacademy.entity.Wagon;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class PlaceTest extends BaseDaoTest {

    private WagonDaoImpl wagonDao = WagonDaoImpl.getInstance();
    private TrainDaoImpl trainDao = TrainDaoImpl.getInstance();
    private PlaceDaoImpl placeDao = PlaceDaoImpl.getInstance();
    private TypePlaceDaoImpl typePlaceDao = TypePlaceDaoImpl.getInstance();
    private TypeWagonDaoImpl typeWagonDao = TypeWagonDaoImpl.getInstance();

    @Test
    public void savePlace() {
        TypePlace typePlace = new TypePlace("нижнее");
        TypeWagon typeWagon = new TypeWagon("купейный");
        Train train = new Train(701, "Брест-Минск");
        Wagon wagon = new Wagon(5, train, typeWagon);
        Place place = new Place(wagon, 55, typePlace, true, 12.5);

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
    }

    @Test
    public void findPlace() {
        List<Place> places = placeDao.findAll();
        assertThat(places, hasSize(48));
        Place place = places.get(0);
        place = placeDao.find(place.getId());
        assertThat(place.getNumber(), equalTo(1));
    }

    @Test
    public void findAllFreePlaceByWagonId() {
        Train train = trainDao.findByName("минск-брест");
        Assert.assertNotNull("Entity is null", train);
        Long trainId = train.getId();
        Wagon wagon = wagonDao.findByNumber(1, trainId);
        Assert.assertNotNull("Entity is null", wagon);
        Long wagonId = wagon.getId();
        List<Place> results = placeDao.findAllFreePlaceByWagonIdAndTrainId(wagonId, trainId);
        assertThat(results, hasSize(3));
    }

    @Test
    public void findCountPlaceByWagonId() {
        Train train = trainDao.findByName("минск-брест");
        Long trainId = train.getId();
        Wagon wagon = wagonDao.findByNumber(1, trainId);
        Long wagonId = wagon.getId();
        List<PlaceDto> places = placeDao.findCountPlaceByWagonId(wagonId);
        assertThat(places, hasSize(3));
    }
}
