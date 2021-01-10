package com.datn.qltccn.service;

import com.datn.qltccn.dto.ThuNhapSearchDTO;
import com.datn.qltccn.model.Thunhap;

import java.util.List;

public interface ThuNhapService extends BaseService<Thunhap> {
    void search(ThuNhapSearchDTO dto);

    List<Integer> getListByMonth(int year);
}
