package com.datn.qltccn.repository;

import com.datn.qltccn.model.Thunhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ThunhapRepository extends JpaRepository<Thunhap, Integer>, JpaSpecificationExecutor<Thunhap> {
    List<Thunhap> findByIdUser(Integer id);

    List<Thunhap> findAllByIdUser(Integer id);
}