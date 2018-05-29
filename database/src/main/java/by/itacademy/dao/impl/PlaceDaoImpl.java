package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.PlaceDao;
import by.itacademy.dto.PlaceDto;
import by.itacademy.entity.Place;
import by.itacademy.entity.Place_;
import by.itacademy.entity.Train;
import by.itacademy.entity.Train_;
import by.itacademy.entity.TypePlace;
import by.itacademy.entity.TypePlace_;
import by.itacademy.entity.Wagon;
import by.itacademy.entity.Wagon_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceDaoImpl extends BaseDao<Long, Place> implements PlaceDao {

    private static final PlaceDaoImpl INSTANCE = new PlaceDaoImpl();

    @Override
    public List<Place> findAllFreePlaceByWagonIdAndTrainId(Long wagonId, Long trainId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Place> criteria = cb.createQuery(Place.class);
            Root<Train> root = criteria.from(Train.class);
            ListJoin<Train, Wagon> wagonJoin = root.join(Train_.wagons);
            ListJoin<Wagon, Place> placeJoin = wagonJoin.join(Wagon_.places);
            criteria.select(placeJoin)
                    .where(cb.and(
                            cb.equal(wagonJoin.get(Wagon_.id), wagonId),
                            cb.equal(root.get(Train_.id), trainId),
                            cb.equal(placeJoin.get(Place_.reserved), false)))
                    .orderBy(cb.asc(placeJoin.get(Place_.number)));

            return session.createQuery(criteria).list();
        }
    }

    @Override
    public List<PlaceDto> findCountPlaceByWagonId(Long wagonId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PlaceDto> criteria = cb.createQuery(PlaceDto.class);
            Root<Wagon> root = criteria.from(Wagon.class);
            ListJoin<Wagon, Place> placeJoin = root.join(Wagon_.places);
            Join<Place, TypePlace> typePlaceJoin = placeJoin.join(Place_.typePlace);
            criteria.select(
                    cb.construct(PlaceDto.class, typePlaceJoin.get(TypePlace_.type),
                            cb.count(placeJoin.get(Place_.number))))
                    .groupBy(typePlaceJoin.get(TypePlace_.type))
                    .having(cb.and(
                            cb.equal(root.get(Wagon_.id), wagonId),
                            cb.equal(placeJoin.get(Place_.reserved), false)))
                    .orderBy(cb.asc(placeJoin.get(Place_.number)));

            return session.createQuery(criteria).list();
        }
    }

    public static PlaceDaoImpl getInstance() {
        return INSTANCE;
    }
}
