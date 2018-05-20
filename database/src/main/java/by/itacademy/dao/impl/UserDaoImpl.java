package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.UserDao;
import by.itacademy.entity.User;
import by.itacademy.entity.User_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDaoImpl extends BaseDao<Long, User> implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    @Override
    public List<User> findByNamePassword(String name, String password) {
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = cb.createQuery(User.class);
            Root<User> root = criteria.from(User.class);
            criteria.select(root)
                    .where(cb.and(
                            cb.equal(root.get(User_.name), name),
                            cb.equal(root.get(User_.password), password)));

            return session.createQuery(criteria).list();
        }
    }

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }
}
