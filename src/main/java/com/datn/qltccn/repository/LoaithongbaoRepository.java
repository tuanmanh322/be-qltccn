package com.datn.qltccn.repository;

import com.datn.qltccn.model.Loaithongbao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LoaithongbaoRepository extends JpaRepository<Loaithongbao, Integer>, JpaSpecificationExecutor<Loaithongbao> {
    List<Loaithongbao> findAllByIdUser(int id);
}