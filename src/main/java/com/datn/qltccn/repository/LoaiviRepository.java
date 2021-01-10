package com.datn.qltccn.repository;

import com.datn.qltccn.model.Loaivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LoaiviRepository extends JpaRepository<Loaivi, Integer>, JpaSpecificationExecutor<Loaivi> {
    List<Loaivi> findAllByIdUser(Integer idU);

    Loaivi findByIdUserAndId(Integer idUser, Integer idLV);
}