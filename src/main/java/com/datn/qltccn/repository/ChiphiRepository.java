package com.datn.qltccn.repository;

import com.datn.qltccn.model.Chiphi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ChiphiRepository extends JpaRepository<Chiphi, Integer>, JpaSpecificationExecutor<Chiphi> {
    List<Chiphi> findByIdUser(Integer id);

    List<Chiphi> findAllByIdLoaiNganSach(Integer id);
}