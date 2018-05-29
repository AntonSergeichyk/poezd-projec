package by.itacademy.service;

import by.itacademy.dao.impl.StationDaoImpl;
import by.itacademy.entity.Station;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StationService {

    private static final StationService INSTANCE = new StationService();

    public List<Station> findAll() {
        return StationDaoImpl.getInstance().findAll();
    }

    public static StationService getInstance() {
        return INSTANCE;
    }
}
