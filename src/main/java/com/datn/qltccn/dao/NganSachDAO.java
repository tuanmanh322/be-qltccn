package com.datn.qltccn.dao;

import com.datn.qltccn.dto.NganSachSearchDTO;

public interface NganSachDAO {
    void searchNganSach(NganSachSearchDTO dto, Integer idLogin);
}
