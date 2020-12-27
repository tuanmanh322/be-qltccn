package com.datn.qltccn.dao.impl;

import com.datn.qltccn.dao.NganSachDAO;
import com.datn.qltccn.dto.NganSachDTO;
import com.datn.qltccn.dto.NganSachSearchDTO;
import com.datn.qltccn.dto.ThuNhapDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NganSachDAOImpl  extends AbstractDAO implements NganSachDAO {
    @Override
    public void searchNganSach(NganSachSearchDTO dto, Integer idLogin) {
        StringBuilder sb = new StringBuilder();
        Map<String, Object> pa = new HashMap<>();
        sb.append(" select distinct u.username ,");
        sb.append(" ns.id, ");
        sb.append(" ns.vonglap,");
        sb.append(" ns.ngaybatdau,");
        sb.append(" ns.loaitien,");
        sb.append(" lns.tenloaingansach,");
        sb.append(" lns.id as idLoaiNganSach,");
        sb.append(" kh.tenkhachhang ");
        sb.append(" from ngansach as ns left join u as u.id = ns.id_user ");
        sb.append(" left join khachhang as kh on kh.id_user = u.id ");
        sb.append(" left join loaingansach as lns on lns.id = ns.id_loaingansach ");
        sb.append(" where 1 = 1 ");
        sb.append(" and u.id =:p_id ");
        pa.put("p_id",idLogin);
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
                        sb.append(" ns.ngaybatdau desc ");
                        break;
                    case "oldmo":
                        sb.append(" ns.ngaybatdau asc ");
                        break;
                    case "rand":
                        sb.append(" rand() ");
                        break;
                }
            });
        }else {
            sb.append(" order by ns.ngaybatdau ");
        }
        searchAndCountTotal(dto, sb.toString(), pa, NganSachDTO.class);
    }
}