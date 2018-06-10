package com.itacademy.service.Impl;

import com.itacademy.entity.User;
import com.itacademy.repository.UserRepository;
import com.itacademy.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        Optional<User> user = userRepository.findByNameAndPassword(name, password);
        return user.orElse(null);
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public List<User> findAll() {
        Iterable<User> result = userRepository.findAll();
        ArrayList<User> users = new ArrayList<>();
        result.forEach(users::add);
        return users;
    }

    @Override
    public User find(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public void update(User object) {

    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }
}
