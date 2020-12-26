package com.datn.qltccn.repository;

import com.datn.qltccn.model.Chiphi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ChiphiRepository extends JpaRepository<Chiphi, Integer>, JpaSpecificationExecutor<Chiphi> {
    Optional<Chiphi> findByIdUser(Integer id);

}