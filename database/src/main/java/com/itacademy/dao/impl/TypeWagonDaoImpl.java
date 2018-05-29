package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.TypeWagonDao;
import by.itacademy.entity.Train;
import by.itacademy.entity.Train_;
import by.itacademy.entity.TypeWagon;
import by.itacademy.entity.Wagon;
import by.itacademy.entity.Wagon_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TypeWagonDaoImpl extends BaseDao<Integer, TypeWagon> implements TypeWagonDao {

    private static final TypeWagonDaoImpl INSTANCE = new TypeWagonDaoImpl();

    @Override
    public List<TypeWagon> findAllByTrainId(Long trainId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TypeWagon> criteria = cb.createQuery(TypeWagon.class);
            Root<Train> root = criteria.from(Train.class);
            Join<Train, Wagon> wagonJoin = root.join(Train_.wagons);
            Join<Wagon, TypeWagon> typeWagonJoin = wagonJoin.join(Wagon_.typeWagon);
            criteria.select(typeWagonJoin)
                    .where(cb.equal(root.get(Train_.id), trainId));

            return session.createQuery(criteria).list();
        }
    }

    public static TypeWagonDaoImpl getInstance() {
        return INSTANCE;
    }
}
