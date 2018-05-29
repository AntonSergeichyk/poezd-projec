package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.TimeTableDao;
import by.itacademy.entity.TimeTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeTableDaoImpl extends BaseDao<Long, TimeTable> implements TimeTableDao {

    private static final TimeTableDaoImpl INSTANCE = new TimeTableDaoImpl();

    @Override
    public List<TimeTable> findByStationsAndDate(Long startStationId, Long finishStationId, LocalDate date, Integer limit, Integer offset) {
        try (Session session = SESSION_FACTORY.openSession()) {
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<TimeTable> criteria = cb.createQuery(TimeTable.class);
//            Root<TimeTable> root = criteria.from(TimeTable.class);
//            Join<TimeTable, Station> startStationJoin = root.join(TimeTable_.stationStart);
//            Join<TimeTable, Station> finishStationJoin = root.join(TimeTable_.stationFinish);
//            criteria.select(root)
//                    .where(cb.and(
//                            cb.equal(startStationJoin.get(Station_.name), startStationId),
//                            cb.equal(finishStationJoin.get(Station_.name), finishStationId),
//                            cb.equal(root.get(TimeTable_.timeStart), Date.valueOf(date))))
//                    .orderBy(cb.asc(root.get(TimeTable_.timeStart)));
//            return session.createQuery(criteria).setFirstResult(offset).setMaxResults(limit).list();
            return session.createQuery("select tt from TimeTable tt join tt.stationStart ss " +
                    "join tt.stationFinish sf where ss.id = :ssId and sf.id =:sfId and tt.timeStart = :ttTimeStart", TimeTable.class)
                    .setParameter("ssId", startStationId)
                    .setParameter("sfId", finishStationId)
                    .setParameter("ttTimeStart", date)
                    .setFirstResult(limit)
                    .setMaxResults(offset)
                    .list();
        }
    }

    public static TimeTableDaoImpl getInstance() {
        return INSTANCE;
    }
}
