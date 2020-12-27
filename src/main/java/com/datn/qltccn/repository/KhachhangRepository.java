package com.datn.qltccn.repository;

import com.datn.qltccn.model.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface KhachhangRepository extends JpaRepository<Khachhang, Integer>, JpaSpecificationExecutor<Khachhang> {
    Optional<Khachhang> findByIdUser(Integer id);
}