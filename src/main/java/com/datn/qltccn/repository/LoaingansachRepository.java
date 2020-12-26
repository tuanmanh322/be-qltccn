package com.datn.qltccn.repository;

import com.datn.qltccn.model.Loaingansach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoaingansachRepository extends JpaRepository<Loaingansach, Integer>, JpaSpecificationExecutor<Loaingansach> {

}