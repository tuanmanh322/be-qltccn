package com.datn.qltccn.repository;

import com.datn.qltccn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    User findByUsername(String username);

    List<User> findAllByIdRole(Integer idRole);
}