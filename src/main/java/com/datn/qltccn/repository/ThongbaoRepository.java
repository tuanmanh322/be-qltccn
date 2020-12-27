package com.datn.qltccn.repository;

import com.datn.qltccn.model.Thongbao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ThongbaoRepository extends JpaRepository<Thongbao, Integer>, JpaSpecificationExecutor<Thongbao> {
    List<Thongbao> findAllByIdloaithongbao(Integer id);


}