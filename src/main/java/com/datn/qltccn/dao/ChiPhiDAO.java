package com.datn.qltccn.dao;

import com.datn.qltccn.dto.ChiPhiDTO;
import com.datn.qltccn.dto.ChiPhiSearchDTO;

import java.util.List;

public interface ChiPhiDAO {
    void searchChiPhi(ChiPhiSearchDTO dto, Integer idlOGIN);

    List<ChiPhiDTO> getAllByMonthAndYearAndIdLoaiNS(int days,int month, int year, Integer idUser, int idLoaiNS);

    List<ChiPhiDTO> getAllByMonthAndDaysIDuser(int days,int month, int year, Integer idUser);
}
