package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.BookingDao;
import by.itacademy.entity.Booking;
import by.itacademy.entity.Booking_;
import by.itacademy.entity.Place;
import by.itacademy.entity.Place_;
import by.itacademy.entity.User;
import by.itacademy.entity.User_;
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
public class BookingDaoImpl extends BaseDao<Long, Booking> implements BookingDao {

    private static final BookingDaoImpl INSTANCE = new BookingDaoImpl();

    @Override
    public List<Booking> findByUserId(Long userId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Booking> criteria = cb.createQuery(Booking.class);
            Root<Booking> root = criteria.from(Booking.class);
            Join<Booking, User> userJoin = root.join(Booking_.user);
            criteria.select(root)
                    .where(cb.equal(userJoin.get(User_.id), userId));

            return session.createQuery(criteria).list();
        }
    }

    @Override
    public List<Booking> findByWagonId(Long wagonId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Booking> criteria = cb.createQuery(Booking.class);
            Root<Booking> root = criteria.from(Booking.class);
            Join<Booking, Place> placeJoin = root.join(Booking_.place);
            Join<Place, Wagon> wagonJoin = placeJoin.join(Place_.wagon);
            criteria.select(root)
                    .where(cb.equal(wagonJoin.get(Wagon_.id), wagonId))
                    .orderBy(cb.asc(placeJoin.get(Place_.number)));

            return session.createQuery(criteria).list();
        }
    }

    public static BookingDaoImpl getInstance() {
        return INSTANCE;
    }
}
