package com.datn.qltccn.service;

import com.datn.qltccn.dto.ChiPhiSearchDTO;
import com.datn.qltccn.model.Chiphi;

import java.util.List;

public interface ChiPhiService extends BaseService<Chiphi> {
    void search(ChiPhiSearchDTO dto);

    List<Integer> getListByMonth(int month);

    List<Integer> getListByIDlns(int month, int year, Integer idLoaiNS);

}
