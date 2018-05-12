package by.itacademy.service;

import by.itacademy.dao.UserDao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BuyerService {

    private static final BuyerService INSTANCE = new BuyerService();

    public Buyer findBuyer() {
        return UserDao.getInstance().find();
    }

    public static BuyerService getInstance() {
        return INSTANCE;
    }
}
