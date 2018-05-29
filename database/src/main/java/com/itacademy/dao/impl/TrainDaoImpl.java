package by.itacademy.dao.impl;

import by.itacademy.entity.Train;
import by.itacademy.entity.Train_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrainDaoImpl extends BaseDao<Long, Train> {

    private static final TrainDaoImpl INSTANCE = new TrainDaoImpl();

    public static TrainDaoImpl getInstance() {
        return INSTANCE;
    }

    public Train findByName(String trainName) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Train> criteria = cb.createQuery(Train.class);
            Root<Train> root = criteria.from(Train.class);
            criteria.select(root)
                    .where(cb.equal(root.get(Train_.name), trainName));

            return session.createQuery(criteria).getSingleResult();
        }
    }
}
