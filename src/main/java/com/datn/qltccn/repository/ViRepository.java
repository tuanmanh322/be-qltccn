package com.datn.qltccn.repository;

import com.datn.qltccn.model.Vi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ViRepository extends JpaRepository<Vi, Integer>, JpaSpecificationExecutor<Vi> {
    List<Vi> findAllByIdUser(Integer idU);

    Optional<Vi> findByIdUserAndIdLoaiVi(Integer idU, Integer idLV);
}