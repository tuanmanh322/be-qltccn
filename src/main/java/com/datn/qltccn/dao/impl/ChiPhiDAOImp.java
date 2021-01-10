package com.datn.qltccn.dao.impl;

import com.datn.qltccn.dao.ChiPhiDAO;
import com.datn.qltccn.dto.ChiPhiDTO;
import com.datn.qltccn.dto.ChiPhiSearchDTO;
import com.datn.qltccn.dto.NganSachDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
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
        sb.append(" from chiphi as cp left join user as u on u.id = cp.id_user ");
        sb.append(" left join khachhang as kh on kh.id_user = u.id ");
        sb.append(" left join loaingansach as lns on lns.id = cp.id_loaingansach ");
        sb.append(" where 1 = 1 ");
        sb.append(" and u.id =:p_id ");
        pa.put("p_id",idlOGIN);
        if (StringUtils.isNotEmpty(dto.getTenloaingansach())){
            sb.append(" and lns.tenloaingansach like :p_khachhang");
            pa.put("p_khachhang", "%" + dto.getTenloaingansach().trim() +"%");
        }
        if (StringUtils.isNotEmpty(dto.getThang())){
            sb.append(" and MONTH(cp.ngaytao) =:p_pmnhfas");
            pa.put("p_pmnhfas", dto.getThang().trim());
        }
        if (StringUtils.isNotEmpty(dto.getYear())){
            sb.append(" and YEAR(cp.ngaytao) =:p_years");
            pa.put("p_years", dto.getYear().trim());
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
            sb.append(" order by cp.ngaytao ");
        }
        searchAndCountTotal(dto, sb.toString(), pa, ChiPhiDTO.class);
    }

    @Override
    public List<ChiPhiDTO> getAllByMonthAndYearAndIdLoaiNS(int days,int month, int year, Integer idUser, int idLoaiNS) {
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
        sb.append(" from chiphi as cp left join user as u on u.id = cp.id_user ");
        sb.append(" left join khachhang as kh on kh.id_user = u.id ");
        sb.append(" left join loaingansach as lns on lns.id = cp.id_loaingansach ");
        sb.append(" where 1 = 1 ");
        sb.append(" and u.id =:p_id ");
        pa.put("p_id",idUser);
        sb.append(" and MONTH(cp.ngaytao) =:p_month");
        pa.put("p_month",month);
        sb.append(" and YEAR(cp.ngaytao) =:p_year");
        pa.put("p_year",year);
        sb.append(" and DAY(cp.ngaytao) =:p_day");
        pa.put("p_day",days);
        if (idLoaiNS > 0){
            sb.append(" and cp.id_loaingansach =:p_lns");
            pa.put("p_lns",idLoaiNS);
        }
        return namedParameterJdbcTemplate().query(sb.toString(),pa, BeanPropertyRowMapper.newInstance(ChiPhiDTO.class));
    }
}
