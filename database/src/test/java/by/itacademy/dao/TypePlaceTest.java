package by.itacademy.dao;

import by.itacademy.dao.impl.TrainDaoImpl;
import by.itacademy.dao.impl.TypePlaceDaoImpl;
import by.itacademy.dao.impl.WagonDaoImpl;
import by.itacademy.entity.TypePlace;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TypePlaceTest extends BaseDaoTest {

    private WagonDaoImpl wagonDao = WagonDaoImpl.getInstance();
    private TrainDaoImpl trainDao = TrainDaoImpl.getInstance();
    private TypePlaceDaoImpl typePlaceDao = TypePlaceDaoImpl.getInstance();
    @Test
    public void saveTypePlace() {
        TypePlace typePlace = new TypePlace("нижнее");
        Integer typePlaceId = typePlaceDao.save(typePlace);
        Assert.assertNotNull("Id is null", typePlaceId);
    }

    @Test
    public void findTypePlace() {
        List<TypePlace> typePlaces = typePlaceDao.findAll();
        assertThat(typePlaces, hasSize(5));
        TypePlace typePlace = typePlaces.get(0);
        typePlace = typePlaceDao.find(typePlace.getId());
        assertThat(typePlace.getType(), Matchers.equalTo("Верхнее"));
    }

    @Test
    public void findAllByWagonId() {
        Long trainId = trainDao.findByName("минск-дзержинск").getId();
        Assert.assertNotNull("Id is null", trainId);
        Long wagonId = wagonDao.findByNumber(1, trainId).getId();
        Assert.assertNotNull("Id is null", wagonId);
        List<TypePlace> results = typePlaceDao.findAllByWagonIdAndTrainId(wagonId, trainId);
        assertThat(results, hasSize(3));
    }
}
