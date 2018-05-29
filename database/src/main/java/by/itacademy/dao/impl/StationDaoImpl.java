package by.itacademy.dao.impl;

import by.itacademy.entity.Station;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StationDaoImpl extends BaseDao<Long, Station> {

    private static final StationDaoImpl INSTANCE = new StationDaoImpl();

    public static StationDaoImpl getInstance() {
        return INSTANCE;
    }
}
