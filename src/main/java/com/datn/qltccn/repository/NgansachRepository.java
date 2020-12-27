package com.datn.qltccn.repository;

import com.datn.qltccn.model.Ngansach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface NgansachRepository extends JpaRepository<Ngansach, Integer>, JpaSpecificationExecutor<Ngansach> {
    List<Ngansach> findByIdUser(Integer id);

    List<Ngansach> findAllByIdLoaiNganSach(Integer id);
}