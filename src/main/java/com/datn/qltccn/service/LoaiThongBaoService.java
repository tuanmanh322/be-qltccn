package com.datn.qltccn.service;

import com.datn.qltccn.dto.LoaiThongBaoSearchDTO;
import com.datn.qltccn.model.Loaithongbao;

public interface LoaiThongBaoService extends BaseService<Loaithongbao> {
    void search(LoaiThongBaoSearchDTO dto);
}
