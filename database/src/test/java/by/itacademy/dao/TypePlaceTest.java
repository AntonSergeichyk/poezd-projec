package by.itacademy.dao;

import by.itacademy.dao.impl.TrainDaoImpl;
import by.itacademy.dao.impl.TypePlaceDaoImpl;
import by.itacademy.dao.impl.WagonDaoImpl;
import by.itacademy.entity.TypePlace;
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
        save(typePlace);
    }

    @Test
    public void findTypePlace() {
        TypePlace typePlace = new TypePlace("нижнее");
        find(typePlace);
    }

    @Test
    public void findAllByWagonId() {
        Long wagonId = wagonDao.findByNumber(1).getId();
        Long trainId = trainDao.findByName("минск-брест").getId();
        List<TypePlace> results = typePlaceDao.findAllByWagonIdAndTrainId(wagonId, trainId);
        assertThat(results, hasSize(5));
    }
}
