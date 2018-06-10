package com.itacademy.repository;

import com.itacademy.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByNameAndPassword(String name, String password);

    User findByName(String name);
}
