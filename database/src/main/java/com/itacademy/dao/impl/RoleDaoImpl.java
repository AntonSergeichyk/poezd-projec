package by.itacademy.dao.impl;

import by.itacademy.entity.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDaoImpl extends BaseDao<Integer, Role> {

    private static final RoleDaoImpl INSTANCE = new RoleDaoImpl();

    public static RoleDaoImpl getInstance() {
        return INSTANCE;
    }
}
