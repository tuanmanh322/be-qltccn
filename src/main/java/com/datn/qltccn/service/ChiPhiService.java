package com.datn.qltccn.service;

import com.datn.qltccn.dto.ChiPhiSearchDTO;
import com.datn.qltccn.model.Chiphi;

public interface ChiPhiService extends BaseService<Chiphi> {
    void search(ChiPhiSearchDTO dto);
}
