package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.WagonDao;
import by.itacademy.entity.Train;
import by.itacademy.entity.Train_;
import by.itacademy.entity.Wagon;
import by.itacademy.entity.Wagon_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WagonDaoImpl extends BaseDao<Long, Wagon> implements WagonDao {

    private static final WagonDaoImpl INSTANCE = new WagonDaoImpl();

    @Override
    public Wagon findByNumber(Integer wagonNumber, Long trainId) {
        try (Session session = SESSION_FACTORY.openSession()) {
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Wagon> criteria = cb.createQuery(Wagon.class);
//            Root<Train> root = criteria.from(Train.class);
//            ListJoin<Train, Wagon> wagonJoin = root.join(Train_.wagons);
//            criteria.select(wagonJoin)
//                    .where(cb.equal(root.get(Train_.number), trainNumber));
//
//            return session.createQuery(criteria).getSingleResult();
            return session.createQuery("select w from Wagon w join w.train t " +
                    "where w.number = :wagonNumber and t.id= :trainId", Wagon.class)
                    .setParameter("wagonNumber", wagonNumber)
                    .setParameter("trainId", trainId)
                    .getSingleResult();
        }
    }

    @Override
    public List<Wagon> findByTrainName(String trainName) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Wagon> criteria = cb.createQuery(Wagon.class);
            Root<Train> root = criteria.from(Train.class);
            ListJoin<Train, Wagon> wagonJoin = root.join(Train_.wagons);
            criteria.select(wagonJoin)
                    .where(cb.equal(root.get(Train_.name), trainName))
                    .orderBy(cb.asc(wagonJoin.get(Wagon_.number)));

            return session.createQuery(criteria).list();
        }
    }

    public static WagonDaoImpl getInstance() {
        return INSTANCE;
    }
}
