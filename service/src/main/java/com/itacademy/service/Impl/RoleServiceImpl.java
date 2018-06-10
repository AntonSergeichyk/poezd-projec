package com.itacademy.service.Impl;

import com.itacademy.entity.Role;
import com.itacademy.repository.RoleRepository;
import com.itacademy.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public List<Role> findAll() {
        Iterable<Role> result = roleRepository.findAll();
        ArrayList<Role> roles = new ArrayList<>();
        result.forEach(roles::add);
        return roles;
    }

    @Override
    public Role find(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null);
    }

    @Override
    public void update(Role object) {

    }

    @Override
    public void delete(Role object) {
        roleRepository.delete(object);
    }
}
