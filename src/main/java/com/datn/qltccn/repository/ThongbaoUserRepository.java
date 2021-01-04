package com.datn.qltccn.repository;

import com.datn.qltccn.model.ThongbaoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ThongbaoUserRepository extends JpaRepository<ThongbaoUser, Integer>, JpaSpecificationExecutor<ThongbaoUser> {
    List<ThongbaoUser> findByIdUser(Integer id);

    List<ThongbaoUser> findAllByIdUser(Integer id);


    List<ThongbaoUser> findAllByIdThongbao(Integer id);
}