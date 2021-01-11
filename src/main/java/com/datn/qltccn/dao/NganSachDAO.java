package com.datn.qltccn.dao;

import com.datn.qltccn.dto.NganSachDTO;
import com.datn.qltccn.dto.NganSachSearchDTO;

import java.util.List;

public interface NganSachDAO {
    void searchNganSach(NganSachSearchDTO dto, Integer idLogin);

    List<NganSachDTO> getAllByMonthAndYearAndIdLoaiNS(int day,int month, int year, Integer idUser);
}
