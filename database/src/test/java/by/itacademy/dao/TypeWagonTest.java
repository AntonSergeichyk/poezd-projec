package by.itacademy.dao;

import by.itacademy.entity.TypeWagon;
import org.junit.Test;

public class TypeWagonTest extends BaseDaoTest {

    @Test
    public void saveWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        save(typeWagon);
    }

    @Test
    public void findWagon() {
        TypeWagon typeWagon = new TypeWagon("купейный");
        find(typeWagon);
    }
}
