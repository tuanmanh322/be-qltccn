package com.datn.qltccn.service;

import com.datn.qltccn.dto.LoaiNganSachSearchDTO;
import com.datn.qltccn.model.Loaingansach;

import java.util.List;

public interface LoaiNganSachService extends BaseService<Loaingansach> {
    void search(LoaiNganSachSearchDTO dto);

    List<Loaingansach> listByUser();
}
