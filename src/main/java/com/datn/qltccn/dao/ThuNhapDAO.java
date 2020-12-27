package com.datn.qltccn.dao;

import com.datn.qltccn.dto.ThuNhapSearchDTO;

public interface ThuNhapDAO  {
    void searchThuNhap(ThuNhapSearchDTO thuNhapSearchDTO, Integer idLogin);
}
