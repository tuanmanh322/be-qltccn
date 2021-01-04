package com.datn.qltccn.repository;

import com.datn.qltccn.model.Chiphi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChiphiRepository extends JpaRepository<Chiphi, Integer>, JpaSpecificationExecutor<Chiphi> {
    List<Chiphi> findByIdUser(Integer id);

    List<Chiphi> findAllByIdUser(Integer id);

    List<Chiphi> findAllByIdLoaiNganSach(Integer id);

    @Query(nativeQuery = true, value = "select cp.* from chiphi as cp where MONTH(cp.ngaytao) =?1 and YEAR(cp.ngaytao) = ?2")
    List<Chiphi> getListByMonth(int month, int year);
}