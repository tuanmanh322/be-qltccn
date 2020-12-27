package com.datn.qltccn.dao;

import com.datn.qltccn.dto.ChiPhiSearchDTO;

public interface ChiPhiDAO {
    void searchChiPhi(ChiPhiSearchDTO dto, Integer idlOGIN);
}
