package com.datn.qltccn.service;

import com.datn.qltccn.dto.NganSachSearchDTO;
import com.datn.qltccn.model.Ngansach;

import java.util.List;

public interface NganSachService extends BaseService<Ngansach> {
    void search(NganSachSearchDTO dto);

    List<Integer> getListByMonth(int year);

    List<Ngansach> getAllNsByMonthAndYear(int month, int year);

    Integer getAllByIDLNS(Integer idLNS);
}
