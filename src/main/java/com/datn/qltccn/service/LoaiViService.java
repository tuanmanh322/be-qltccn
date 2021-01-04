package com.datn.qltccn.service;

import com.datn.qltccn.dto.LoaiViSearchDTO;
import com.datn.qltccn.model.Loaivi;

public interface LoaiViService extends BaseService<Loaivi> {
    void search(LoaiViSearchDTO dto);
}
