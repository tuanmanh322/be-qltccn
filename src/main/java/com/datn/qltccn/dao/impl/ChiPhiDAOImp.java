package com.datn.qltccn.dao.impl;

import com.datn.qltccn.dao.ChiPhiDAO;
import com.datn.qltccn.dto.ChiPhiDTO;
import com.datn.qltccn.dto.ChiPhiSearchDTO;
import com.datn.qltccn.dto.NganSachDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ChiPhiDAOImp extends AbstractDAO implements ChiPhiDAO {
    @Override
    public void searchChiPhi(ChiPhiSearchDTO dto, Integer idlOGIN) {
        StringBuilder sb = new StringBuilder();
        Map<String, Object> pa = new HashMap<>();
        sb.append(" select distinct u.username ,");
        sb.append(" cp.id, ");
        sb.append(" cp.loaitien,");
        sb.append(" cp.ngaytao,");
        sb.append(" cp.mota,");
        sb.append(" cp.sotien,");
        sb.append(" lns.tenloaingansach,");
        sb.append(" lns.id as idLoaiNganSach,");
        sb.append(" kh.tenkhachhang ");
        sb.append(" from chiphi as cp left join u as u.id = cp.id_user ");
        sb.append(" left join khachhang as kh on kh.id_user = u.id ");
        sb.append(" left join loaingansach as lns on lns.id = cp.id_loaingansach ");
        sb.append(" where 1 = 1 ");
        sb.append(" and u.id =:p_id ");
        pa.put("p_id",idlOGIN);
        if (StringUtils.isNotEmpty(dto.getTenloaingansach())){
            sb.append(" and lns.tenloaingansach =:p_khachhang");
            pa.put("p_khachhang", "%" + dto.getTenloaingansach() +"%");
        }
        if (!dto.getOrders().isEmpty()){
            sb.append(" order by ");
            dto.getOrders().forEach(or -> {
                String property = StringUtils.trimToEmpty(or.getProperty());
                switch (property){
                    case "newmo":
                        sb.append(" cp.ngaytao desc ");
                        break;
                    case "oldmo":
                        sb.append(" cp.ngaytao asc ");
                        break;
                    case "rand":
                        sb.append(" rand() ");
                        break;
                }
            });
        }else {
            sb.append(" order by ns.ngaytao ");
        }
        searchAndCountTotal(dto, sb.toString(), pa, ChiPhiDTO.class);
    }
}
