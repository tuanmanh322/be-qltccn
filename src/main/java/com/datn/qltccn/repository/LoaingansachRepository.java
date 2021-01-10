package com.datn.qltccn.repository;

import com.datn.qltccn.model.Loaingansach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LoaingansachRepository extends JpaRepository<Loaingansach, Integer>, JpaSpecificationExecutor<Loaingansach> {
    List<Loaingansach> findAllByIdUser(Integer idU);
}