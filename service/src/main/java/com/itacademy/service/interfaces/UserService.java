package com.itacademy.service.interfaces;

import com.itacademy.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends BaseService<Long, User>, UserDetailsService {

    User findByNameAndPassword(String name, String password);
}
