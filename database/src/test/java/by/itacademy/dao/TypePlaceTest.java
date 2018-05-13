package by.itacademy.dao;

import by.itacademy.entity.TypePlace;
import org.junit.Test;

public class TypePlaceTest extends BaseDaoTest {

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
}
