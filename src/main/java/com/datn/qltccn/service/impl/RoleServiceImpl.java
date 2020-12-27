package com.datn.qltccn.service.impl;

import com.datn.qltccn.model.Role;
import com.datn.qltccn.model.User;
import com.datn.qltccn.repository.RoleRepository;
import com.datn.qltccn.repository.UserRepository;
import com.datn.qltccn.service.RoleService;
import com.datn.qltccn.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    private final UserService userService;

    private final UserRepository userRepository;

    public RoleServiceImpl(RoleRepository roleRepository, UserService userService, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.getOne(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
        List<User> users = userRepository.findAllByIdRole(id);
        if (!CollectionUtils.isEmpty(users)){
            for (User u : users){
                userService.deleteUser(u.getId());
            }
        }
    }

    @Override
    public void edit(Role role) {
        Role  ro = roleRepository.getOne(role.getId());
        ro.setNameRole(role.getNameRole());
        roleRepository.save(ro);
    }
}
