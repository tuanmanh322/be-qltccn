package com.datn.qltccn.repository;

import com.datn.qltccn.model.Thunhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ThunhapRepository extends JpaRepository<Thunhap, Integer>, JpaSpecificationExecutor<Thunhap> {
    List<Thunhap> findByIdUser(Integer id);

    List<Thunhap> findAllByIdUser(Integer id);

    @Query(nativeQuery = true, value = "select cp.* from thunhap as cp where MONTH(cp.ngaytao) =?1 and YEAR(cp.ngaytao) = ?2 and cp.id_user =?3")
    List<Thunhap> getListByMonth(int month, int year, Integer idUser);
}