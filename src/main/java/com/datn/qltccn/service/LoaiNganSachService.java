package com.datn.qltccn.service;

import com.datn.qltccn.dto.LoaiNganSachSearchDTO;
import com.datn.qltccn.model.Loaingansach;

public interface LoaiNganSachService extends BaseService<Loaingansach> {
    void search(LoaiNganSachSearchDTO dto);
}
