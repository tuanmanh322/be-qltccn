package com.datn.qltccn.service;

import com.datn.qltccn.dto.ThuNhapSearchDTO;
import com.datn.qltccn.model.Thunhap;

public interface ThuNhapService extends BaseService<Thunhap> {
    void search(ThuNhapSearchDTO dto);
}
