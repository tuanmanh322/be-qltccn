package com.datn.qltccn.repository;

import com.datn.qltccn.model.Thunhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ThunhapRepository extends JpaRepository<Thunhap, Integer>, JpaSpecificationExecutor<Thunhap> {
    Optional<Thunhap> findByIdUser(Integer id);
}