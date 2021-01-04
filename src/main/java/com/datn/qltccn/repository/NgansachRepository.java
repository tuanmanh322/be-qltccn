package com.datn.qltccn.repository;

import com.datn.qltccn.model.Ngansach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NgansachRepository extends JpaRepository<Ngansach, Integer>, JpaSpecificationExecutor<Ngansach> {
    List<Ngansach> findByIdUser(Integer id);

    List<Ngansach> findAllByIdUser(Integer id);


    List<Ngansach> findAllByIdLoaiNganSach(Integer id);

    @Query(nativeQuery = true, value = "select cp.* from ngansach as cp where MONTH(cp.ngaytao) =?1 and YEAR(cp.ngaytao) = ?2")
    List<Ngansach> getListByMonth(int month, int year);
}