package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.TypePlaceDao;
import by.itacademy.entity.Place;
import by.itacademy.entity.Place_;
import by.itacademy.entity.Train;
import by.itacademy.entity.Train_;
import by.itacademy.entity.TypePlace;
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
public class TypePlaceDaoImpl extends BaseDao<Integer, TypePlace> implements TypePlaceDao {

    private static final TypePlaceDaoImpl INSTANCE = new TypePlaceDaoImpl();

    @Override
    public List<TypePlace> findAllByWagonIdAndTrainId(Long wagonId, Long trainId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TypePlace> criteria = cb.createQuery(TypePlace.class);
            Root<Place> root = criteria.from(Place.class);
            Join<Place, TypePlace> typePlaceJoin = root.join(Place_.typePlace);
            Join<Place, Wagon> wagonJoin = root.join(Place_.wagon);
            Join<Wagon, Train> trainJoin = wagonJoin.join(Wagon_.train);
            criteria.select(typePlaceJoin)
                    .where(cb.and(
                            cb.equal(wagonJoin.get(Wagon_.id), wagonId),
                            cb.equal(trainJoin.get(Train_.id), trainId)));

            return session.createQuery(criteria).list();

        }
    }

    public static TypePlaceDaoImpl getInstance() {
        return INSTANCE;
    }
}
