package com.datn.qltccn.dao.impl;

import com.datn.qltccn.dao.ThuNhapDAO;
import com.datn.qltccn.dto.ThuNhapDTO;
import com.datn.qltccn.dto.ThuNhapSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ThuNhapDAOImpl extends AbstractDAO implements ThuNhapDAO {
    @Override
    public void searchThuNhap(ThuNhapSearchDTO thuNhapSearchDTO, Integer idLogin) {
        StringBuilder sb = new StringBuilder();
        Map<String, Object> pa = new HashMap<>();
        sb.append(" select distinct u.username ,");
        sb.append(" tn.id, ");
        sb.append(" tn.sotien,");
        sb.append(" tn.loaitien,");
        sb.append(" tn.kihan,");
        sb.append(" tn.ngaytao,");
        sb.append(" tn.mota,");
        sb.append(" kh.tenkhachhang ");
        sb.append(" from thunhap as tn left join u as u.id = tn.id_user ");
        sb.append(" left join khachhang as kh on kh.id_user = u.id ");
        sb.append(" where 1 = 1 ");
        sb.append(" and u.id =:p_id ");
        pa.put("p_id",idLogin);
        if (StringUtils.isNotEmpty(thuNhapSearchDTO.getMota())){
            sb.append(" and kh.mota =:p_khachhang");
            pa.put("p_khachhang", "%" + thuNhapSearchDTO.getMota() +"%");
        }
        if (!thuNhapSearchDTO.getOrders().isEmpty()){
            sb.append(" order by ");
            thuNhapSearchDTO.getOrders().forEach(or -> {
                String property = StringUtils.trimToEmpty(or.getProperty());
                switch (property){
                    case "newmo":
                        sb.append(" tn.sotien desc ");
                        break;
                    case "oldmo":
                        sb.append(" tn.sotien asc ");
                        break;
                    case "rand":
                        sb.append(" rand() ");
                        break;
                }
            });
        }else {
            sb.append(" order by tn.sotien ");
        }
        searchAndCountTotal(thuNhapSearchDTO, sb.toString(), pa, ThuNhapDTO.class);
    }
}
