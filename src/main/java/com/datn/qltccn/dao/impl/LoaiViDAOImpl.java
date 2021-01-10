package com.datn.qltccn.dao.impl;

import com.datn.qltccn.dao.LoaiViDAO;
import com.datn.qltccn.dto.LoaiViDTO;
import com.datn.qltccn.dto.LoaiViSearchDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LoaiViDAOImpl extends AbstractDAO implements LoaiViDAO {
    @Override
    public void searchLV(LoaiViSearchDTO dto) {
        StringBuilder sb = new StringBuilder();
        Map<String, Object> pa = new HashMap<>();
        sb.append(" select distinct lv.id ,");
        sb.append(" lv.ten_vi as tenVi ");
        sb.append(" from loaivi as lv  ");
        sb.append(" where 1=1 ");
        sb.append(" order by lv.ten_vi ");
        searchAndCountTotal(dto,sb.toString(),pa, LoaiViDTO.class);
    }
}
