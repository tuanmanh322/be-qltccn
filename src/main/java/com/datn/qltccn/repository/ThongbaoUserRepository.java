package com.datn.qltccn.repository;

import com.datn.qltccn.model.ThongbaoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ThongbaoUserRepository extends JpaRepository<ThongbaoUser, Integer>, JpaSpecificationExecutor<ThongbaoUser> {
    Optional<ThongbaoUser> findByIdUser(Integer id);
}