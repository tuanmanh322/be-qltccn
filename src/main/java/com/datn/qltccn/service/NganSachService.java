package com.datn.qltccn.service;

import com.datn.qltccn.dto.NganSachSearchDTO;
import com.datn.qltccn.model.Ngansach;

public interface NganSachService extends BaseService<Ngansach> {
    void search(NganSachSearchDTO dto);
}
