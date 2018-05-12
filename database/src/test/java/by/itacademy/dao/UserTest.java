package by.itacademy.dao;

import by.itacademy.entity.Role;
import org.junit.Test;

public class BuyerTest extends BaseDaoTest {

    @Test
    public void saveUser() {
        Role role = new Role("user");
        Buyer buyer = new Buyer(role, "Anton", "11111111", "qwerty@gmail.com");
        save(role, buyer);
    }

    @Test
    public void findUser() {
        Role role = new Role("user");
        Buyer buyer = new Buyer(role, "Anton", "11111111", "qwerty@gmail.com");
        find(role, buyer);
    }
}
