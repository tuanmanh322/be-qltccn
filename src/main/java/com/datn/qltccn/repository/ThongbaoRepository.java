package com.datn.qltccn.repository;

import com.datn.qltccn.model.Thongbao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThongbaoRepository extends JpaRepository<Thongbao, Integer>, JpaSpecificationExecutor<Thongbao> {
    List<Thongbao> findAllByIdloaithongbao(Integer id);

    @Query(nativeQuery = true,value = "select t.* \n" +
            " from \n" +
            "    (select tb.* \n" +
            "     from thongbao  as tb\n" +
            "     order by tb.ngaytao desc limit 10)as t \n" +
            " WHERE t.id_user = 2 and DAY(SYSDATE()) = DAY(t.ngaytao)\n" +
            " order by t.ngaytao desc")
    List<Thongbao> findAllByIdUser(Integer id);

}